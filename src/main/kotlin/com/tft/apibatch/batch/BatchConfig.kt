package com.tft.apibatch.batch

import com.tft.apibatch.entry.Deck
import com.tft.apibatch.entry.Match
import com.tft.apibatch.entry.User
import com.tft.apibatch.feign.AsiaApiClient
import com.tft.apibatch.feign.KrApiClient
import com.tft.apibatch.feign.dto.LeagueListDTO
import com.tft.apibatch.feign.dto.SummonerDTO
import com.tft.apibatch.mapstructure.DeckMapper
import com.tft.apibatch.mapstructure.ParticipantMapper
import com.tft.apibatch.repository.DeckRepository
import com.tft.apibatch.repository.MatchRepository
import com.tft.apibatch.repository.UserRepository
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.properties.Delegates


@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
class BatchConfig{

    @Autowired
    lateinit var jobBuilderFactory: JobBuilderFactory
    @Autowired
    lateinit var stepBuilderFactory: StepBuilderFactory

    @Autowired
    lateinit var krApiClient : KrApiClient
    @Autowired
    lateinit var asiaApiClient: AsiaApiClient

    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var matchRepository: MatchRepository
    @Autowired
    lateinit var deckRepository: DeckRepository

    @Value("\${api-token}")
    lateinit var apiToken : String

    @Value("\${break-time}")
    val breakTime: Long? = null

    @Bean
    fun job(): Job {
        return jobBuilderFactory["sendNotificationBeforeClassJob"]
            .start(collectSummonerId())
//            .next()
            .build()
    }

    @Bean
    fun collectSummonerId(): Step {
        return stepBuilderFactory["collectSummonerId"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->
                val leagueListDTO : LeagueListDTO = krApiClient.callChallengerLeagues(apiToken)

                userRepository.saveAll(
                    leagueListDTO.entries
                        .map { User(it.summonerId) }
                )

                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun collectPuuId(): Step {
        return stepBuilderFactory["collectPuuId"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                val users = userRepository.findAllByPuuidIsNull()

                users.forEach {
                    val summonerDTO : SummonerDTO = krApiClient.callSummoner(apiToken, it.summonerId)
                    println(summonerDTO)


                    it.puuid = summonerDTO.puuid
                }


                userRepository.saveAll(users)
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun collectMatchId(): Step {
        return stepBuilderFactory["collectMatchId"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                val users = userRepository.findAllByPuuidIsNotNullAndIsProcessedFalse()

                users.forEach {
                    val callMatches : List<String>? = asiaApiClient.callMatches(apiToken, it!!.puuid!!, 0, 100);

                    matchRepository.saveAll(
                        callMatches!!
                            .map { Match(it) }
                    )
                    it.isProcessed = true
                }

                userRepository.saveAll(users)
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun collectMatchInfo(): Step {
        return stepBuilderFactory["collectMatchId"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                val matches = matchRepository.findAllByParticipantsIsNull();

                matches.forEach {
                    Thread.sleep(breakTime!!)
                    val matchDTO = asiaApiClient.callMatch(apiToken, it.match_id)

                    it.participants = matchDTO.info.participants
                        .map { ParticipantMapper.INSTANCE.dtoToEntry(it) }
                }

                matchRepository.saveAll(matches)

                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun collectDecks(): Step {
        return stepBuilderFactory["collectDecks"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                val matches = matchRepository.findAllByParticipantsIsNotNullAndIsProcessedFalse();

                val deckList = mutableListOf<Deck>()
                for (match in matches) {
                    val decks = match.participants!!
                        .map { DeckMapper.INSTANCE.participantToDeck(it, match.match_id) }
                    deckList.addAll(decks)
                    match.isProcessed = true
                }

                matchRepository.saveAll(matches)
                deckRepository.saveAll(deckList);

                RepeatStatus.FINISHED
            }
            .build()
    }


}