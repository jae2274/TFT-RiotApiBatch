package com.tft.apibatch.entity

import org.junit.jupiter.api.Test
import com.tft.apibatch.entity.TFTStatsFixture.*
import org.assertj.core.api.Assertions

class TftStatsTest {

    @Test
    fun addChampions() {
        val standard = TFTStatsFixture().standard.championsStats()
        val another = TFTStatsFixture().another.championsStats()
        val expected = TFTStatsFixture().expected.championsStats()

        standard.addMap(another)

        Assertions.assertThat(standard).isEqualTo(expected)
    }

    @Test
    fun addItems() {
        val standard = TFTStatsFixture().standard.itemStats()
        val another = TFTStatsFixture().another.itemStats()
        val expected = TFTStatsFixture().expected.itemStats()

        standard.addMap(another)

        Assertions.assertThat(standard).isEqualTo(expected)
    }

    @Test
    fun addSynergies() {

        val standard = TFTStatsFixture().standard.synergyStats()
        val another = TFTStatsFixture().another.synergyStats()
        val expected = TFTStatsFixture().expected.synergyStats()

        standard.addMap(another)

        Assertions.assertThat(standard).isEqualTo(expected)
    }

    @Test
    fun addAugments() {

        val standard = TFTStatsFixture().standard.augmentStats()
        val another = TFTStatsFixture().another.augmentStats()
        val expected = TFTStatsFixture().expected.augmentStats()

        standard.addMap(another)

        Assertions.assertThat(standard).isEqualTo(expected)
    }

    @Test
    fun addTftStats() {
        val gameVersion = "Version 13.9.506.4846 (Apr 28 2023/10:09:23) [PUBLIC] <Releases/13.9>"
        val season = "TFTSet8_2"
        val seasonNumber = 8


        val standard = TFTStatsFixture().standard.tftStats(season, seasonNumber, gameVersion)
        val another = TFTStatsFixture().another.tftStats(season, seasonNumber, gameVersion)
        val expected = TFTStatsFixture().expected.tftStats(season, seasonNumber, gameVersion)

        standard.add(another)

        Assertions.assertThat(standard).isEqualTo(expected)
    }
}