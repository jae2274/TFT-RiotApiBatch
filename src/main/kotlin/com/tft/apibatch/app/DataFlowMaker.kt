package com.tft.apibatch.app

import kotlinx.coroutines.flow.*
import org.springframework.stereotype.Component

@Component
class DataFlowMaker(
    private val appService: AppService
) {
    suspend fun createFlow(): Flow<String> {
        val puuids = appService.getSummonerIds(3)
            .let { summonerId -> appService.getPuuids(summonerId) }

        return puuids
            .asFlow()
            .mapNotException { puuid -> appService.getMatchIds(puuid, 0, 3) }
            .flatMapConcat { it.asFlow() }
            .mapNotException { matchId -> appService.getMatch(matchId) }
    }
}

private fun <T, R> Flow<T>.mapNotException(suspendFunction1: suspend (T) -> R): Flow<R> {
    return this.map {
        try {
            suspendFunction1(it)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
        .mapNotNull { it }
}

