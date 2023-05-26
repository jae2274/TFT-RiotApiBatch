package com.tft.apibatch.entity

import com.tft.apibatch.api.MatchFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


@DisplayName("IdSet 클래스의 union과 listOf 메소드 테스트")
class IdSetUtilTest {
    private lateinit var decks: List<Deck>

    @BeforeEach
    fun init() {
        decks = MatchFixture.matchDTOs
            .flatMap { Deck.listOf(it) }
    }

    @Test
    @DisplayName("deck 리스트로 IdSet을 생성 후, 생성된 IdSet 객체를 검사한다.")
    fun createIdSet() {
        val idSets = IdSet.listOf(decks)

        decks.groupBy { it.info.tft_set_core_name to it.info.tft_set_number }
            .forEach { deckEntry ->
                val (seasonPair, decksBySeason) = deckEntry
                val (season, seasonNumber) = seasonPair
                val championIds = decksBySeason
                    .flatMap { it.units }
                    .map { it.character_id }
                    .toSet()

                val itemIds = decksBySeason
                    .flatMap { it.units }
                    .flatMap { it.itemNames }
                    .toSet()

                val synergyIds = decksBySeason
                    .flatMap { it.traits }
                    .map { it.name }
                    .toSet()

                val augmentIds = decksBySeason
                    .flatMap { it.augments }
                    .toSet()


                idSets.assertHasAndEquals(season, seasonNumber, IdType.CHAMPION, championIds)
                idSets.assertHasAndEquals(season, seasonNumber, IdType.ITEM, itemIds)
                idSets.assertHasAndEquals(season, seasonNumber, IdType.SYNERGY, synergyIds)
                idSets.assertHasAndEquals(season, seasonNumber, IdType.AUGMENT, augmentIds)
            }


        Assertions.assertThat(idSets.size).isEqualTo(8)

    }

    @Test
    @DisplayName("IdSet의 union 메소드 테스트")
    fun unionTest() {

        val idSet1 = IdSet(
            season = "TFTSet8_2",
            seasonNumber = 8,
            type = IdType.CHAMPION,
            ids = setOf("TFT8_Camille", "TFT8_Pyke", "TFT8_Alistar")
        )


        val idSet2 = IdSet(
            season = "TFTSet8_2",
            seasonNumber = 8,
            type = IdType.CHAMPION,
            ids = setOf("TFT8_Camille", "TFT8_Pyke", "TFT8_Viego")
        )

        val expectedResult = IdSet(
            season = "TFTSet8_2",
            seasonNumber = 8,
            type = IdType.CHAMPION,
            ids = setOf("TFT8_Camille", "TFT8_Pyke", "TFT8_Alistar", "TFT8_Viego")
        )


        val result = idSet1.union(idSet2)

        Assertions.assertThat(result).isEqualTo(expectedResult)
    }
}

fun Collection<IdSet>.assertHasAndEquals(season: String, seasonNumber: Int, idType: IdType, targetIds: Set<String>) {
    val filteredList =
        this.filter { it.season == season && it.seasonNumber == seasonNumber && it.type == idType }

    Assertions.assertThat(filteredList.size).isEqualTo(1)
    Assertions.assertThat(filteredList[0].ids).isEqualTo(targetIds)

}