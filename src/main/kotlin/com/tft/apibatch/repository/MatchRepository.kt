package com.tft.apibatch.repository

import com.querydsl.core.types.dsl.BooleanExpression
import com.tft.apibatch.entry.Match
import com.tft.apibatch.entry.QMatch.match
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface MatchRepository : MongoRepository<Match, String>, QuerydslPredicateExecutor<Match> {
    fun findForMappingParticipants(size: Int): List<Match> {
        val where: BooleanExpression = match.participants.isEmpty

        return findAll(where, match.info.game_datetime.desc()).take(size)
    }

    fun findForExtractingDecks(countOfMatch: Int): List<Match> {
        val where: BooleanExpression = match.participants.isNotEmpty.and(match.isProcessed.isFalse)

        return findAll(where, match.info.game_datetime.desc()).take(countOfMatch)
    }
}