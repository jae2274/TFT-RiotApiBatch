package com.tft.apibatch.entry

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "match")
data class Match(
    @Id
    val match_id: String,
    var info: Info? = null,
    var participants: List<Participant>? = null,
    var isProcessed: Boolean = false,
): BaseEntity() {

    data class Info(
        val game_datetime: Long,
        val game_length: Float,
        val queue_id: Int,
        val tft_game_type: String,
        val tft_set_core_name: String,
        val tft_set_number: Int,
    )

    data class Participant (
        val gold_left: Int?,
        val last_round: Int?,
        val level: Int?,
        val placement: Int?,
        val players_eliminated: Int?,
        val puuid: String?,
        val time_eliminated: Float?,
        val total_damage_to_players: Int?,
        val traits: List<Trait>?,
        val units: List<Unit>?,
    )

    data class Trait (
        val name: String?,
        val num_units: Int?,
        val style: Int?,
        val tier_current: Int?,
        val tier_total: Int?,
    )

    data class Unit (
        val items: List<Int>?,
        val itemNames: List<String>?,
        val character_id: String?,
        val chosen: String?,
        val name: String?,
        val rarity: Int?,
        val tier: Int?,
    )
}