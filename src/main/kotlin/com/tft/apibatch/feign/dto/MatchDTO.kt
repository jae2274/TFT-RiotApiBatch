package com.tft.apibatch.feign.dto


import lombok.*


data class MatchDTO (
    val metadata: MetadataDTO?,
    val info: InfoDTO?,
)
{
    data class MetadataDTO (
        val data_version: String?,
        val match_id: String?,
        val participants: List<String>?,
    )
    
    data class InfoDTO (
        val game_datetime: Long?,
        val game_length: Float?,
        val game_variation: String?,
        val game_version: String?,
        val participants: List<ParticipantDTO>?,
        val queue_id: Int?,
        val tft_set_number: Int?,
    )

    data class ParticipantDTO (
        val gold_left: Int?,
        val last_round: Int?,
        val level: Int?,
        val placement: Int?,
        val players_eliminated: Int?,
        val puuid: String?,
        val time_eliminated: Float?,
        val total_damage_to_players: Int?,
        val traits: List<TraitDTO>?,
        val units: List<UnitDTO>?,
    )
    
    data class TraitDTO (
        val name: String?,
        val num_units: Int?,
        val style: Int?,
        val tier_current: Int?,
        val tier_total: Int?,
    )
    
    data class UnitDTO (
        val items: List<Int>?,
        val itemNames: List<String>?,
        val character_id: String?,
        val chosen: String?,
        val name: String?,
        val rarity: Int?,
        val tier: Int?,
    )
}