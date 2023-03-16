package com.tft.apibatch.repository

import com.tft.apibatch.entry.WinnerDeck
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface WinnerDeckRepository : MongoRepository<WinnerDeck, String> {

    @Query("{ 'match_id' : { '\$in' : ?0 } }")
    fun findAllByMatchId(ids: Iterable<String>): Iterable<WinnerDeck>
}