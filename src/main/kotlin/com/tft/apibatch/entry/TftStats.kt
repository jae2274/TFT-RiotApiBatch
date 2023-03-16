package com.tft.apibatch.entry

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tftStats")
data class TftStats(
        @Indexed(unique = true)
        val gameVersion: String,
        val season: String,
        val seasonNumber: Int,
        val champions: MutableMap<String, ChampionStats> = mutableMapOf(),
        val synergies: MutableMap<String, SynergyStats> = mutableMapOf(),
        val items: MutableMap<String, Stats> = mutableMapOf(),
        val augments: MutableMap<String, Stats> = mutableMapOf(),
        @Id
        var _id: String? = null,
) : BaseEntity() {
    data class ChampionStats(
            var totalPlacement: Long = 0,
            var totalCount: Long = 0,
            val tiers: MutableMap<Int, Stats> = mutableMapOf(),
            val items: MutableMap<String, Stats> = mutableMapOf(),
    )

    data class SynergyStats(
            val tiers: MutableMap<Int, Stats> = mutableMapOf(),
    )

    data class Stats(
            var totalPlacement: Long = 0,
            var totalCount: Long = 0,
    )
}
