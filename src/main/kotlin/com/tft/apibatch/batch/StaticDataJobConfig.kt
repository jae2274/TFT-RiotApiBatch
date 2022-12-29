package com.tft.apibatch.batch

import com.tft.apibatch.entry.CharacterSet
import com.tft.apibatch.entry.Deck
import com.tft.apibatch.entry.ItemSet
import com.tft.apibatch.entry.QDeck.deck
import com.tft.apibatch.entry.SynergySet
import com.tft.apibatch.repository.CharacterSetRepository
import com.tft.apibatch.repository.DeckRepository
import com.tft.apibatch.repository.ItemSetRepository
import com.tft.apibatch.repository.SynergySetRepository
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
    lateinit var synergySetRepository: SynergySetRepository

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
                val synergySet = findSynergySet(recentSeason)

                itemSetRepository.save(ItemSet(recentSeason, itemSet))

                characterSetRepository.save(CharacterSet(recentSeason, characterSet))

                synergySetRepository.save(SynergySet(recentSeason, synergySet))

                RepeatStatus.FINISHED
            }
            .build()
    }

    private val TFT_SEASON_FIELD = "${deck.info.tft_set_core_name}".removePrefix("${deck}.")
    private val TFT_ITEM_NAMES_FIELD = "${deck.units.metadata.name}.${deck.units.any().itemNames.metadata.name}"
    private val TFT_CHARACTER_FIELD = "${deck.units.metadata.name}.${deck.units.any().character_id.metadata.name}"
    private val TFT_SYNERGY_FIELD = "${deck.traits.metadata.name}.${deck.traits.any().name.metadata.name}"

    fun findItemSet(season: String): List<String> {

        val query = Query()
        query.addCriteria(
            Criteria.where(TFT_SEASON_FIELD)
                .isEqualTo(season)
        )

        //TODO : 추후 units.itemNames 하드코딩을 제거할 수 있는 방법을 고민해보자
        return mongoTemplate.findDistinct(query, TFT_ITEM_NAMES_FIELD, Deck::class.java, String::class.java)
    }

    fun findCharacterSet(season: String): List<String> {

        val query = Query()
        query.addCriteria(
            Criteria.where(TFT_SEASON_FIELD)
                .isEqualTo(season)
        )

        //TODO : 추후 units.character_id 하드코딩을 제거할 수 있는 방법을 고민해보자
        return mongoTemplate.findDistinct(query, TFT_CHARACTER_FIELD, Deck::class.java, String::class.java)
    }

    fun findSynergySet(season: String): List<String> {

        val query = Query()
        query.addCriteria(
            Criteria.where(TFT_SEASON_FIELD)
                .isEqualTo(season)
        )

        //TODO : 추후 units.character_id 하드코딩을 제거할 수 있는 방법을 고민해보자
        return mongoTemplate.findDistinct(query, TFT_SYNERGY_FIELD, Deck::class.java, String::class.java)
    }
}