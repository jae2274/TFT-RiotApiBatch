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


@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
class BatchConfig {

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


    @Bean
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
    fun collectSummonerId(@Value("#{jobParameters[collectSummonerIdCnt]}") collectSummonerIdCnt: Long): Step {
        return stepBuilderFactory["collectSummonerId"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                for (i in 1..collectSummonerIdCnt) {
                    val userIds = krApiClient.callChallengerLeagues(apiToken)
                        .entries
                        .map { it.summonerId }

                    val existedSummonerIds =
                        userRepository.findAllBySummonerIdInAndPuuidIsNotNull(userIds).map { it.summonerId }

                    val willSaved = userIds.filter { !existedSummonerIds.contains(it) }

                    userRepository.saveAll(
                        willSaved.map { User(it) }
                    )
                }

                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    @JobScope
    fun collectPuuId(@Value("#{jobParameters[collectPuuIdCnt]}") collectPuuIdCnt: Long): Step {
        return stepBuilderFactory["collectPuuId"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                if (collectPuuIdCnt > 0) {
                    val users = userRepository.findAllByPuuidIsNull(PageRequest.of(0, collectPuuIdCnt.toInt()))

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
    fun collectMatchId(@Value("#{jobParameters[collectMatchIdCnt]}") collectMatchIdCnt: Long): Step {
        return stepBuilderFactory["collectMatchId"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                if (collectMatchIdCnt > 0) {
                    val users = userRepository.findAllByPuuidIsNotNullAndIsProcessedFalse(
                        PageRequest.of(
                            0,
                            collectMatchIdCnt.toInt()
                        )
                    )

                    for (user in users) {

                        val callMatches = asiaApiClient.callMatches(apiToken, user!!.puuid!!, 0, 100)
                        saveMatcheIds(callMatches)

                        user.isProcessed = true
                        userRepository.save(user)
                    }
                }

                RepeatStatus.FINISHED
            }
            .build()
    }

    private fun saveMatcheIds(matchIds: Collection<String>) {
        val existedMatchIds = matchRepository.findAllById(matchIds).map { it.match_id }

        val willSaved = matchIds.filter { !existedMatchIds.contains(it) }

        matchRepository.saveAll(
            willSaved
                .map { Match(it) }
        )
    }

    @Bean
    @JobScope
    fun collectMatchInfo(@Value("#{jobParameters[collectMatchInfoCnt]}") collectMatchInfoCnt: Long): Step {
        return stepBuilderFactory["collectMatchInfo"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                if (collectMatchInfoCnt > 0) {
                    val matches =
                        matchRepository.findAllByParticipantsIsNull(PageRequest.of(0, collectMatchInfoCnt.toInt()))

                    for (match in matches) {

                        val matchDTO = asiaApiClient.callMatch(apiToken, match.match_id)

                        match.participants = matchDTO.info.participants
                            .map { TFTMapper.INSTANCE.participantFromDTO(it) }

                        match.info = TFTMapper.INSTANCE.infoFromDTO(matchDTO.info)

                        matchRepository.save(match)
                    }
                }

                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    @JobScope
    fun collectDeck(@Value("#{jobParameters[collectDeckCnt]}") collectDeckCnt: Long): Step {
        return stepBuilderFactory["collectDeck"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                if (collectDeckCnt > 0) {
                    val matches = matchRepository.findAllByParticipantsIsNotNullAndIsProcessedFalse(
                        PageRequest.of(
                            0,
                            collectDeckCnt.toInt()
                        )
                    )

                    for (match in matches) {

                        val decks = match.participants!!
                            .map { TFTMapper.INSTANCE.participantToDeck(it, match.match_id, match.info!!) }

                        deckRepository.saveAll(decks)

                        match.isProcessed = true
                        matchRepository.save(match)
                    }
                }

                RepeatStatus.FINISHED
            }
            .build()
    }

}