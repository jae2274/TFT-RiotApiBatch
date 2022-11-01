package com.tft.apibatch.repository

import com.tft.apibatch.entry.Match
import org.springframework.data.mongodb.repository.MongoRepository

interface MatchRepository : MongoRepository<Match, String>{
    fun findAllByParticipantsIsNull():List<Match>
    fun findAllByParticipantsIsNotNullAndIsProcessedFalse():List<Match>
}