package com.tft.apibatch.repository

import com.tft.apibatch.entry.Deck
import com.tft.apibatch.entry.QDeck.deck
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface DeckRepository : MongoRepository<Deck, String>, QuerydslPredicateExecutor<Deck> {


    fun findRecentSeason(): String {
        val recentDeck = findAll(deck.info.game_datetime.desc()).first()

        checkNotNull(recentDeck) { "Collection deck is empty" }
        val info = checkNotNull(recentDeck.info)
        return checkNotNull(info.tft_set_core_name)
    }
}