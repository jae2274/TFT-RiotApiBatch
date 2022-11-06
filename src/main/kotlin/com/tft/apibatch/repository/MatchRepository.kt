package com.tft.apibatch.repository

import com.tft.apibatch.entry.Match
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository

interface MatchRepository : MongoRepository<Match, String>{
    fun findAllByParticipantsIsNull(pageable: Pageable):List<Match>
    fun findAllByParticipantsIsNotNullAndIsProcessedFalse(pageable:Pageable):List<Match>

}