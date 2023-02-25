package com.tft.apibatch.entry

import com.tft.apibatch.feign.dto.MatchDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "deck")
data class Deck(
        @Id
        var _id: String? = null,
        var match_id: String = "",
        var info: Info = Info(),
        var gold_left: Int? = null,
        var last_round: Int? = null,
        var level: Int? = null,
        var placement: Int? = null,
        var traits: List<Trait> = emptyList(),
        var units: List<Unit> = emptyList(),
        var augments: List<String> = emptyList(),
) : BaseEntity() {
    companion object {
        fun listOf(matchDTO: MatchDTO): List<Deck> {
            return matchDTO.info.participants
                    .map { participant ->
                        Deck(
                                match_id = matchDTO.metadata.match_id,
                                info = Info.of(matchDTO.info),
                                gold_left = participant.gold_left,
                                last_round = participant.last_round,
                                level = participant.level,
                                placement = participant.placement,
                                traits = Trait.listOf(participant.traits),
                                units = Unit.listOf(participant.units),
                                augments = participant.augments,
                        )
                    }
        }
    }


    data class Info(
            var game_datetime: Long? = null,
            var game_length: Float? = null,
            var queue_id: Int? = null,
            var tft_game_type: String? = null,
            var tft_set_core_name: String = "",
            var tft_set_number: Int = 0,
    ) {
        companion object {
            fun of(infoDTO: MatchDTO.InfoDTO): Info {
                return Info(
                        game_datetime = infoDTO.game_datetime,
                        game_length = infoDTO.game_length,
                        queue_id = infoDTO.queue_id,
                        tft_game_type = infoDTO.tft_game_type,
                        tft_set_core_name = infoDTO.tft_set_core_name,
                        tft_set_number = infoDTO.tft_set_number,
                )
            }
        }
    }

    data class Trait(
            var name: String = "",
            var num_units: Int? = null,
            var style: Int? = null,
            var tier_current: Int? = null,
            var tier_total: Int? = null,
    ) {
        companion object {
            fun listOf(traits: List<MatchDTO.TraitDTO>): List<Trait> {
                return traits.map { of(it) }
            }

            private fun of(trait: MatchDTO.TraitDTO): Trait {
                return Trait(
                        name = trait.name,
                        num_units = trait.num_units,
                        style = trait.style,
                        tier_current = trait.tier_current,
                        tier_total = trait.tier_total,
                )
            }
        }
    }

    data class Unit(
            var items: List<Int>? = null,
            var itemNames: List<String> = listOf(),
            var character_id: String = "",
            var chosen: String? = null,
            var name: String? = null,
            var rarity: Int? = null,
            var tier: Int? = null,
    ) {
        companion object {
            fun listOf(units: List<MatchDTO.UnitDTO>): List<Unit> {
                return units.map { of(it) }
            }

            private fun of(unit: MatchDTO.UnitDTO): Unit {
                return Unit(
                        items = unit.items,
                        itemNames = unit.itemNames,
                        character_id = unit.character_id,
                        chosen = unit.chosen,
                        name = unit.name,
                        rarity = unit.rarity,
                        tier = unit.tier,
                )
            }
        }
    }
}


