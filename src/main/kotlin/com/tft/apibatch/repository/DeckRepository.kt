package com.tft.apibatch.repository

import com.querydsl.core.types.dsl.BooleanExpression
import com.tft.apibatch.entry.Deck
import com.tft.apibatch.entry.QDeck.deck
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface DeckRepository : MongoRepository<Deck, String>, QuerydslPredicateExecutor<Deck> {
    fun findAllByCharacterId(characterId: String): Page<Deck> {
        val where: BooleanExpression = deck.units.any().character_id.eq(characterId)

        val pageRequest = PageRequest.of(0, 5)

        return findAll(where, pageRequest)
    }
}