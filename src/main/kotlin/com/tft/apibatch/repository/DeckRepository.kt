package com.tft.apibatch.repository

import com.tft.apibatch.entry.Deck
import com.tft.apibatch.entry.MongoFieldConstant
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface DeckRepository : MongoRepository<Deck, String>, QuerydslPredicateExecutor<Deck> {


    fun findRecentSeason(): String {
        val pageable = PageRequest.of(0, 1, MongoFieldConstant.SORT_BY_DATETIME)
        val recentDeck = findAll(pageable).first()

        checkNotNull(recentDeck) { "Collection deck is empty" }
        val info = checkNotNull(recentDeck.info)
        return checkNotNull(info.tft_set_core_name)
    }
}