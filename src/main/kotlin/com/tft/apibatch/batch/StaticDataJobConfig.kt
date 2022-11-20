package com.tft.apibatch.batch

import com.tft.apibatch.entry.CharacterSet
import com.tft.apibatch.entry.Deck
import com.tft.apibatch.entry.ItemSet
import com.tft.apibatch.entry.QDeck
import com.tft.apibatch.repository.CharacterSetRepository
import com.tft.apibatch.repository.DeckRepository
import com.tft.apibatch.repository.ItemSetRepository
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo


@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
class StaticDataJobConfig {

    @Autowired
    lateinit var jobBuilderFactory: JobBuilderFactory

    @Autowired
    lateinit var stepBuilderFactory: StepBuilderFactory

    @Autowired
    lateinit var deckRepository: DeckRepository

    @Autowired
    lateinit var itemSetRepository: ItemSetRepository

    @Autowired
    lateinit var characterSetRepository: CharacterSetRepository

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate


    @Bean(name = ["staticDataJob"])
    fun staticDataJob(): Job {
        return jobBuilderFactory["staticDataJob"]
            .start(staticDataStep())
            .build()
    }

    @Bean
    @JobScope
    fun staticDataStep(): Step {
        return stepBuilderFactory["staticDataStep"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->

                val recentSeason = deckRepository.findRecentSeason()

                val itemSet = findItemSet(recentSeason)
                val characterSet = findCharacterSet(recentSeason)

                itemSetRepository.save(ItemSet(recentSeason, itemSet))

                characterSetRepository.save(CharacterSet(recentSeason, characterSet))

                RepeatStatus.FINISHED
            }
            .build()
    }

    private val TFT_SEASON_FIELD = "${QDeck.deck.info.tft_set_core_name}".removePrefix("${QDeck.deck}.")

    fun findItemSet(season: String): List<String> {

        val query = Query()
        query.addCriteria(
            Criteria.where(TFT_SEASON_FIELD)
                .isEqualTo(season)
        )

        //TODO : 추후 units.itemNames 하드코딩을 제거할 수 있는 방법을 고민해보자
        return mongoTemplate.findDistinct(query, "units.itemNames", Deck::class.java, String::class.java)
    }

    fun findCharacterSet(season: String): List<String> {

        val query = Query()
        query.addCriteria(
            Criteria.where(TFT_SEASON_FIELD)
                .isEqualTo(season)
        )

        //TODO : 추후 units.character_id 하드코딩을 제거할 수 있는 방법을 고민해보자
        return mongoTemplate.findDistinct(query, "units.character_id", Deck::class.java, String::class.java)
    }
}