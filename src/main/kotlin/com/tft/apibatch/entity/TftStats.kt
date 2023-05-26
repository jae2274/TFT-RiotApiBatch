package com.tft.apibatch.entity

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "tftStats")
data class TftStats(
    @Indexed(unique = true)
    val gameVersion: String,
    val season: String,
    val seasonNumber: Int,
    val champions: MutableMap<String, ChampionStats> = mutableMapOf(),
    val synergies: MutableMap<String, SynergyStats> = mutableMapOf(),
    val items: MutableMap<String, ItemStats> = mutableMapOf(),
    val augments: MutableMap<String, Stats> = mutableMapOf(),
    @Id
    var _id: String? = null,
) : BaseEntity() {
    data class ChampionStats(
        override var totalPlacement: Long = 0,
        override var totalCount: Long = 0,
        val tiers: MutableMap<Int, Stats> = mutableMapOf(),
        val items: MutableMap<String, Stats> = mutableMapOf(),
    ) : BaseStats(
        totalPlacement = totalPlacement,
        totalCount = totalCount,
        extensionStats = listOf(tiers, items)
    ) {
        companion object
    }

    data class ItemStats(
        override var totalPlacement: Long = 0,
        override var totalCount: Long = 0,
        val champions: MutableMap<String, Stats> = mutableMapOf(),
    ) : BaseStats(
        totalPlacement = totalPlacement,
        totalCount = totalCount,
        extensionStats = listOf(champions)
    ) {
        companion object
    }

    data class SynergyStats(
        override var totalPlacement: Long = 0,
        override var totalCount: Long = 0,
        val tiers: MutableMap<Int, Stats> = mutableMapOf(),
    ) : BaseStats(
        totalPlacement = totalPlacement,
        totalCount = totalCount,
        extensionStats = listOf(tiers)
    ) {
        companion object
    }

    data class Stats(
        override var totalPlacement: Long = 0,
        override var totalCount: Long = 0,
    ) : BaseStats(
        totalPlacement = totalPlacement,
        totalCount = totalCount,
        extensionStats = emptyList()
    ) {
        companion object
    }


    companion object
}

open class BaseStats(
    @Transient
    open var totalPlacement: Long,
    @Transient
    open var totalCount: Long,

    extensionStats: List<MutableMap<out Any, TftStats.Stats>>
) {
    @Transient
    val _extensionStats: List<MutableMap<Any, TftStats.Stats>> =
        extensionStats as List<MutableMap<Any, TftStats.Stats>>
}