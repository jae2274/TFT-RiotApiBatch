package com.tft.apibatch.batch

import com.tft.apibatch.entry.Match
import com.tft.apibatch.entry.User
import com.tft.apibatch.feign.AsiaApiClient
import com.tft.apibatch.feign.KrApiClient
import com.tft.apibatch.feign.dto.SummonerDTO
import com.tft.apibatch.mapstructure.TFTMapper
import com.tft.apibatch.repository.DeckRepository
import com.tft.apibatch.repository.MatchRepository
import com.tft.apibatch.repository.UserRepository
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.PageRequest
import kotlin.math.ceil


@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
class CollectDataJobConfig {

    @Autowired
    lateinit var jobBuilderFactory: JobBuilderFactory

    @Autowired
    lateinit var stepBuilderFactory: StepBuilderFactory

    @Autowired
    lateinit var krApiClient: KrApiClient

    @Autowired
    lateinit var asiaApiClient: AsiaApiClient

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var matchRepository: MatchRepository

    @Autowired
    lateinit var deckRepository: DeckRepository

    @Value("\${api-token}")
    lateinit var apiToken: String


    @Bean(name = ["collectJob"])
    fun collectJob(): Job {
        return jobBuilderFactory["collectJob"]
            .start(collectSummonerId(1))
            .next(collectPuuId(Long.MAX_VALUE))
            .next(collectMatchId(Long.MAX_VALUE))
            .next(collectMatchInfo(Long.MAX_VALUE))
            .next(collectDeck(Long.MAX_VALUE))
            .build()
    }

    @Bean
    @JobScope
    fun collectSummonerId(@Value("#{jobParameters[willSavedSummonerIdCnt]}") willSavedSummonerIdCnt: Long): Step {
        return stepBuilderFactory["collectSummonerId"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                var totalCount = 0;

                for (i in 1..100) {
                    if (totalCount >= willSavedSummonerIdCnt) {
                        break
                    }

                    val userIds = krApiClient.callChallengerLeagues(apiToken)
                        .entries
                        .map { it.summonerId }

                    val existedSummonerIds =
                        userRepository.findAllBySummonerIdInAndPuuidIsNotNull(userIds).map { it.summonerId }

                    var willSaved = userIds.filter { !existedSummonerIds.contains(it) }

                    if (willSavedSummonerIdCnt - totalCount < willSaved.size) {
                        willSaved = willSaved.subList(0, (willSavedSummonerIdCnt - totalCount).toInt())
                    }

                    userRepository.saveAll(
                        willSaved.map { User(it) }
                    )
                    totalCount += willSaved.size
                }

                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    @JobScope
    fun collectPuuId(@Value("#{jobParameters[willUpdatedPuuIdCnt]}") willUpdatedPuuIdCnt: Long): Step {
        return stepBuilderFactory["collectPuuId"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                if (willUpdatedPuuIdCnt > 0) {
                    val users = userRepository.findAllByPuuidIsNull(PageRequest.of(0, willUpdatedPuuIdCnt.toInt()))

                    for (user in users) {

                        val summonerDTO: SummonerDTO = krApiClient.callSummoner(apiToken, user.summonerId)
                        println(summonerDTO)

                        user.puuid = summonerDTO.puuid
                        userRepository.save(user)
                    }
                }

                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    @JobScope
    fun collectMatchId(@Value("#{jobParameters[willSavedMatchCnt]}") willSavedMatchCnt: Long): Step {
        return stepBuilderFactory["collectMatchId"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                if (willSavedMatchCnt > 0) {
                    val users = userRepository.findAllByPuuidIsNotNullAndIsProcessedFalse()

                    var totalCount = 0

                    for (user in users) {
                        if (totalCount >= willSavedMatchCnt) {
                            break
                        }

                        val puuid = checkNotNull(user.puuid) { "puuid is null. match_id: ${user.summonerId}" }

                        val callMatches = asiaApiClient.callMatches(apiToken, puuid, 0, 200)

                        val existedMatchIds = matchRepository.findAllById(callMatches).map { it.match_id }

                        var willSaved = callMatches.filter { !existedMatchIds.contains(it) }

                        if (willSavedMatchCnt - totalCount < willSaved.size) {
                            willSaved = willSaved.subList(0, (willSavedMatchCnt - totalCount).toInt())
                        }

                        matchRepository.saveAll(
                            willSaved
                                .map { Match(it) }
                        )
                        totalCount += willSaved.size

                        user.isProcessed = true
                        userRepository.save(user)
                    }
                }

                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    @JobScope
    fun collectMatchInfo(@Value("#{jobParameters[willUpdatedMatchCnt]}") willUpdatedMatchCnt: Long): Step {
        return stepBuilderFactory["collectMatchInfo"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                if (willUpdatedMatchCnt > 0) {
                    val matches = matchRepository.findForMappingParticipants(willUpdatedMatchCnt.toInt())

                    val attachedmatches = matches.map { match ->
                        val matchDTO = asiaApiClient.callMatch(apiToken, match.match_id)

                        match.participants = matchDTO.info.participants
                            .map { TFTMapper.INSTANCE.participantFromDTO(it) }

                        match.info = TFTMapper.INSTANCE.infoFromDTO(matchDTO.info)
                        match
                    }

                    matchRepository.saveAll(attachedmatches)
                }

                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    @JobScope
    fun collectDeck(@Value("#{jobParameters[willConvertedMatchCnt]}") willConvertedMatchCnt: Long): Step {
        return stepBuilderFactory["collectDeck"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                if (willConvertedMatchCnt > 0) {
                    val pageSize = 100

                    val pageCount = ceil(willConvertedMatchCnt / pageSize.toDouble()).toInt()

                    for (pageNum in 0..pageCount) {
                        val matches = matchRepository.findForExtractingDecks(PageRequest.of(0, pageSize))

                        if (matches.isEmpty())
                            break

                        for (match in matches) {
                            val participants =
                                checkNotNull(match.participants) { "participants is null. match_id: ${match.match_id}" }
                            val info = checkNotNull(match.info) { "info is null. match_id: ${match.match_id}" }

                            val decks = participants
                                .map { TFTMapper.INSTANCE.participantToDeck(it, match.match_id, info) }

                            deckRepository.saveAll(decks)

                            match.isProcessed = true
                            matchRepository.save(match)

                        }
                    }
                }

                RepeatStatus.FINISHED
            }
            .build()
    }

}