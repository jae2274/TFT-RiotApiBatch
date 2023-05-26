package com.tft.apibatch.entity

import com.tft.apibatch.api.MatchFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CreateTftStatsTest {

    private lateinit var decks: List<Deck>

    @BeforeEach
    fun init() {
        decks = MatchFixture.matchDTOs
            .flatMap { Deck.listOf(it) }
    }

    @Test
    @DisplayName("deck 리스트로 TftStats 객체를 생성 후, 이전 로직으로 생성된 객체와 비교한다.")
    fun test() {


        val afterTftStatsList = TftStats.listOf(decks)
        val beforeTftStatsList =
            decks.groupBy { Triple(it.info.tft_set_core_name, it.info.tft_set_number, it.info.game_version) }
                .map { deckEntry ->
                    val (season, seasonNumber, gameVersion) = deckEntry.key
                    TftStats(
                        season = season,
                        seasonNumber = seasonNumber,
                        gameVersion = gameVersion,

                        ).also { it.beforeRefactorLogic(deckEntry.value) }
                }

        Assertions.assertThat(afterTftStatsList).isEqualTo(beforeTftStatsList)
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