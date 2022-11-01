package com.tft.apibatch.entry

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "deck")
data class Deck (
    @Id
    val _id: String? = null,
    var match_id: String,
    val gold_left: Int?,
    val last_round: Int?,
    val level: Int?,
    val placement: Int?,
    val traits: List<Trait>?,
    val units: List<Unit>?,
){
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