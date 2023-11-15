package com.tft.apibatch.domain.service

import com.tft.apibatch.domain.entity.Match
import com.tft.apibatch.domain.repository.MatchRepository
import org.springframework.stereotype.Service

@Service
class MatchService(
    private val matchIdRepository: MatchRepository
) {
    fun excludeExistedMatchIds(matchIds: Iterable<String>): List<String> {
        val existedMatchIds = matchIdRepository.findAllById(matchIds).map { it.matchId }

        return matchIds - existedMatchIds.toSet()
    }

    fun saveMatchId(matchId: String): Match =
        matchIdRepository.save(Match(matchId, System.currentTimeMillis()))
}