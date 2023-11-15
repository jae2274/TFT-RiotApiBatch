package com.tft.apibatch.domain.service

import com.tft.apibatch.domain.entity.Match
import com.tft.apibatch.domain.repository.MatchRepository
import org.springframework.stereotype.Service

@Service
class MatchService(
    private val matchIdRepository: MatchRepository,
    private val cachedMatchIds: MutableSet<String> = mutableSetOf()
) {
    fun excludeExistedMatchIds(matchIds: Iterable<String>): List<String> {
        val notCachedMatchIds = matchIds - cachedMatchIds


        if (notCachedMatchIds.isEmpty()) {
            return emptyList()
        } else {
            val savedMatchIds = matchIdRepository.findAllById(notCachedMatchIds).map { it.matchId }
                .also { cachedMatchIds.addAll(it) }

            return notCachedMatchIds - savedMatchIds.toSet()
        }
    }

    fun saveMatchId(matchId: String): Match {
        cachedMatchIds.add(matchId)
        return matchIdRepository.save(Match(matchId, System.currentTimeMillis()))
    }
}