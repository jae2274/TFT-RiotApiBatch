package com.tft.apibatch.repository

import com.tft.apibatch.entry.Match
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface MatchRepository : MongoRepository<Match, String>, QuerydslPredicateExecutor<Match> {
    fun findAllByParticipantsIsNull(pageable: Pageable): List<Match>
    fun findAllByParticipantsIsNotNullAndIsProcessedFalse(pageable: Pageable): List<Match>

    //    fun findByInfo_Game_datetime
//    fun findRecentMatch(): Match
}