package com.tft.apibatch.repository

import com.tft.apibatch.entity.WinnerDeck
import org.springframework.data.mongodb.repository.ExistsQuery
import org.springframework.data.mongodb.repository.MongoRepository

interface WinnerDeckRepository : MongoRepository<WinnerDeck, String> {
    @ExistsQuery("{ 'match_id' : ?0 }")
    fun existsByMatch_id(matchId: String): Boolean

    fun findTopByOrderByCreatedAtDesc(): WinnerDeck
}