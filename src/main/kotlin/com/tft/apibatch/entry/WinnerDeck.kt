package com.tft.apibatch.entry

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "winnerDeck")
data class WinnerDeck(
        @Id
        var _id: String,
        var match_id: String,
        var info: Info,
        var gold_left: Int,
        var last_round: Int,
        var level: Int,
        var traits: List<Trait>,
        var units: List<Unit>,
        var augments: List<String>,
) : BaseDeck() {
    companion object {

        fun of(deck: Deck): WinnerDeck {
            return WinnerDeck(
                    _id = deck._id!!,
                    match_id = deck.match_id,
                    info = deck.info,
                    gold_left = deck.gold_left,
                    last_round = deck.last_round,
                    level = deck.level,
                    traits = deck.traits,
                    units = deck.units,
                    augments = deck.augments,
            )
        }
    }
}

