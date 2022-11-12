package com.tft.apibatch.entry

import com.querydsl.core.annotations.QueryEntity
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@QueryEntity
@Document(collection = "deck")
data class Deck(
    @Id
    var _id: String? = null,
    var match_id: String = "",
    @Field(name = "info")
    var info: Info? = null,
    var gold_left: Int? = null,
    var last_round: Int? = null,
    var level: Int? = null,
    var placement: Int? = null,
    @Field(name = "traits")
    var traits: List<Trait>? = null,
    @Field(name = "units")
    var units: List<Unit>? = null,
) : BaseEntity()

@Entity
@QueryEntity
data class Info(
    var game_datetime: Long? = null,
    var game_length: Float? = null,
    var queue_id: Int? = null,
    var tft_game_type: String? = null,
    var tft_set_core_name: String? = null,
    var tft_set_number: Int? = null,
)

@Entity
@QueryEntity
data class Trait(
    var name: String? = null,
    var num_units: Int? = null,
    var style: Int? = null,
    var tier_current: Int? = null,
    var tier_total: Int? = null,
)

@Entity
@QueryEntity
data class Unit(
    var items: List<Int>? = null,
    var itemNames: List<String>? = null,
    var character_id: String? = null,
    var chosen: String? = null,
    var name: String? = null,
    var rarity: Int? = null,
    var tier: Int? = null,
)