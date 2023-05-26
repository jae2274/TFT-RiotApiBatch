package com.tft.apibatch.entity

import com.tft.apibatch.repository.DeckRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension


@Repository
interface DeckRepositoryForTest : MongoRepository<Deck, String> {
    @Query("{'info.game_version': ?0}")
    fun findTop20ByInfo_Game_version(gameVersion: String, pageable: Pageable): List<Deck>
}

@ExtendWith(SpringExtension::class)
@DataMongoTest
@ActiveProfiles("local")
class TftStatsUtilTest(
//    private val deckRepository: DeckRepositoryForTest
) {
    @Autowired
    private lateinit var deckRepository: DeckRepositoryForTest

    @Test
    fun test() {
        val season = "TFTSet8_2"
        val seasonNumber = 8
        val gameVersion = "Version 13.9.506.4846 (Apr 28 2023/10:09:23) [PUBLIC] <Releases/13.9>"

        val decks =
//            deckRepository.findAll()
            deckRepository.findTop20ByInfo_Game_version(gameVersion, PageRequest.of(0, 20))

        val beforeTftStats = TftStats(
            season = season,
            seasonNumber = seasonNumber,
            gameVersion = gameVersion
        ).also { it.beforeRefactorLogic(decks) }


        val decks2 =
//            deckRepository.findAll()
            deckRepository.findTop20ByInfo_Game_version(gameVersion, PageRequest.of(0, 20))
        val afterTftStats = TftStats.of(season, seasonNumber, gameVersion, decks2)

        Assertions.assertThat(afterTftStats).isEqualTo(beforeTftStats)
    }
}


fun TftStats.beforeRefactorLogic(decks: Collection<Deck>) {
    for (deck in decks) {
        for (augment in deck.augments) {
            val augmentStats = this.augments.getOrPut(augment) { TftStats.Stats() }
            augmentStats.totalCount += 1
            augmentStats.totalPlacement += deck.placement
        }

        for (trait in deck.traits) {
            val synergyStats = this.synergies.getOrPut(trait.name) { TftStats.SynergyStats() }

            if (trait.tier_current != 0) {
                synergyStats.totalCount += 1
                synergyStats.totalPlacement += deck.placement
            }

            val synergyTierStats = synergyStats.tiers.getOrPut(trait.tier_current) { TftStats.Stats() }
            synergyTierStats.totalCount += 1
            synergyTierStats.totalPlacement += deck.placement
        }

        for (unit in deck.units) {
            val championStats = this.champions.getOrPut(unit.character_id) { TftStats.ChampionStats() }
            championStats.totalCount += 1
            championStats.totalPlacement += deck.placement

            val championTierStats = championStats.tiers.getOrPut(unit.tier) { TftStats.Stats() }
            championTierStats.totalCount += 1
            championTierStats.totalPlacement += deck.placement

            for (itemName in unit.itemNames) {
                val championItemStats = championStats.items.getOrPut(itemName) { TftStats.Stats() }
                championItemStats.totalCount += 1
                championItemStats.totalPlacement += deck.placement

                val itemStats = this.items.getOrPut(itemName) { TftStats.ItemStats() }
                itemStats.totalCount += 1
                itemStats.totalPlacement += deck.placement
                val itemChampionStats = itemStats.champions.getOrPut(unit.character_id) { TftStats.Stats() }
                itemChampionStats.totalCount += 1
                itemChampionStats.totalPlacement += deck.placement
            }
        }
    }
}