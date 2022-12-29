package com.tft.apibatch.entry

import org.springframework.data.domain.Sort

interface MongoFieldConstant {
    companion object {
        val TFT_SEASON_FIELD = "${QDeck.deck.info.tft_set_core_name}".removePrefix("${QDeck.deck}.")
        val TFT_ITEM_NAMES_FIELD = "${QDeck.deck.units.metadata.name}.${QDeck.deck.units.any().itemNames.metadata.name}"
        val TFT_CHARACTER_FIELD =
            "${QDeck.deck.units.metadata.name}.${QDeck.deck.units.any().character_id.metadata.name}"
        val TFT_SYNERGY_FIELD = "${QDeck.deck.traits.metadata.name}.${QDeck.deck.traits.any().name.metadata.name}"
        val TFT_MATCH_GAMEDATETIME = "${QMatch.match.info.game_datetime}".removePrefix("${QMatch.match}")

        val SORT_BY_DATETIME = Sort.by(MongoFieldConstant.TFT_MATCH_GAMEDATETIME).descending()
    }
}