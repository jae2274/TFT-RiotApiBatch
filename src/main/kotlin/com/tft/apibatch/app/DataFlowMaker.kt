package com.tft.apibatch.app

import com.tft.apibatch.api.dto.MatchResponse
import kotlinx.coroutines.flow.*
import org.springframework.stereotype.Component

@Component
class DataFlowMaker(
    private val appService: AppService
) {
    suspend fun createFlow(): Flow<MatchResponse> {
        val puuids = appService.getSummonerIds(3)
            .let { summonerId -> appService.getPuuids(summonerId) }

        return puuids
            .asFlow()
            .mapNotException { puuid -> appService.getMatchIds(puuid, 0, 3) }
            .flatMapConcat { it.asFlow() }
            .mapNotException { matchId -> appService.getMatch(matchId) }
            .filter { match -> appService.isLatest(match.info.game_version) }
    }
}

private fun <T, R> Flow<T>.mapNotException(suspendFunction1: suspend (T) -> R): Flow<R> {
    return this.map {
        try {
            Result.success(suspendFunction1(it))
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
        .filter { it.isSuccess }
        .map { it.getOrThrow() }
}

