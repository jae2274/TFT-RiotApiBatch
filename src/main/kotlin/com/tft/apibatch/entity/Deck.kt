package com.tft.apibatch.entity

import com.tft.apibatch.api.dto.MatchDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "deck")
@CompoundIndex(def = "{'match_id': 1, 'placement': 1}", unique = true)
data class Deck(
    @Id
    var _id: String? = null,
    var match_id: String,
    var info: Info,
    var gold_left: Int,
    var last_round: Int,
    var level: Int,
    var placement: Int,
    var traits: List<Trait>,
    var units: List<Unit>,
    var augments: List<String>,
) : BaseDeck() {
    companion object {
        fun listOf(matchDTO: MatchDTO): List<Deck> {
            return matchDTO.info.participants
                .map { participant -> of(matchDTO.metadata.match_id, matchDTO.info, participant) }
        }

        fun of(match_id: String, info: MatchDTO.InfoDTO, participant: MatchDTO.ParticipantDTO): Deck {
            return Deck(
                match_id = match_id,
                info = Info.of(info),
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

fun Collection<Deck>.checkAllSameSeason() {
    this.map { it.info.tft_set_core_name }.distinct()
        .also { check(it.size == 1) { "deck contains multiple season $it" } }
    this.map { it.info.tft_set_number }.distinct()
        .also { check(it.size == 1) { "deck contains multiple seasonNumber $it" } }
}

fun Collection<Deck>.checkValidSeason(season: String, seasonNumber: Int) {
    checkAllSameSeason()
    this.map { it.info.tft_set_core_name }
        .also { check(it[0] == season) { "different season: ${it[0]}, $season" } }

    this.map { it.info.tft_set_number }
        .also { check(it[0] == seasonNumber) { "different seasonNumber: ${it[0]}, $season" } }
}

fun Collection<Deck>.checkAllSameVersion() {
    this.map { it.info.game_version }.distinct()
        .also { check(it.size == 1) { "deck contains multiple version $it" } }
}

fun Collection<Deck>.checkValidGameVersion(gameVersion: String) {
    checkAllSameVersion()
    this.map { it.info.game_version }
        .also { check(it[0] == gameVersion) { "different version:  ${it[0]}, $gameVersion" } }
}


