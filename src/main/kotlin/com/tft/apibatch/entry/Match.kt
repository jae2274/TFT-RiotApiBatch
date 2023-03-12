package com.tft.apibatch.entry

import com.tft.apibatch.feign.dto.MatchDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "match")
data class Match(
        @Id
        val match_id: String = "",
        var info: Info?,
        var participants: List<Participant>?,
) : BaseEntity() {

    data class Info(
            var game_datetime: Long?,
            var game_length: Float?,
            var queue_id: Int?,
            var tft_game_type: String,
            var tft_set_core_name: String,
            var tft_set_number: Int,
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

    data class Participant(
            var gold_left: Int,
            var last_round: Int,
            var level: Int,
            var placement: Int,
            var puuid: String?,
            var traits: List<Trait>,
            var units: List<Unit>,
            var augments: List<String>,
    ) {
        companion object {
            fun listOf(matchDTO: MatchDTO): List<Participant> {
                return matchDTO.info.participants
                        .map { participant ->
                            Participant(
                                    gold_left = participant.gold_left,
                                    last_round = participant.last_round,
                                    level = participant.level,
                                    placement = participant.placement,
                                    puuid = participant.puuid,
                                    traits = Trait.listOf(participant.traits),
                                    units = Unit.listOf(participant.units),
                                    augments = participant.augments,
                            )
                        }
            }
        }
    }

    data class Trait(
            var name: String,
            var num_units: Int,
            var style: Int,
            var tier_current: Int,
            var tier_total: Int,
    ) {
        companion object {
            fun listOf(traits: List<MatchDTO.TraitDTO>): List<Trait> {
                return traits.map { of(it) }
            }

            fun of(trait: MatchDTO.TraitDTO): Trait {
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
            var items: List<Int>?,
            var itemNames: List<String>,
            var character_id: String,
            var chosen: String?,
            var name: String?,
            var rarity: Int,
            var tier: Int,
    ) {
        companion object {
            fun listOf(units: List<MatchDTO.UnitDTO>): List<Unit> {
                return units.map { of(it) }
            }

            fun of(unit: MatchDTO.UnitDTO): Unit {
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

    companion object {
        fun of(matchDTO: MatchDTO): Match {
            return Match(
                    match_id = matchDTO.metadata.match_id,
                    info = Info.of(matchDTO.info),
                    participants = Participant.listOf(matchDTO),
            )
        }
    }
}