package com.tft.apibatch.repository

import com.tft.apibatch.entity.WinnerDeck
import org.springframework.data.mongodb.repository.ExistsQuery
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface WinnerDeckRepository : MongoRepository<WinnerDeck, String> {

    @ExistsQuery("{ 'match_id' : ?0 }")
    fun existsByMatch_id(matchId: String): Boolean
}