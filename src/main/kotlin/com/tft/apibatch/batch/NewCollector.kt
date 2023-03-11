package com.tft.apibatch.batch

import com.tft.apibatch.api.RiotApiClient
import com.tft.apibatch.service.DataService
import kotlinx.coroutines.flow.*
import org.springframework.stereotype.Component

@Component
class NewCollector(
        private val apiClient: RiotApiClient,
        private val dataService: DataService
) {
    suspend fun collectData() {
        flow {
            while (true) {
                apiClient.callChallengerLeagues()
                        ?.let { leagueListDTO ->
                            leagueListDTO.entries.forEach { emit(it) }
                        }
            }
        }
                .buffer(0)
                .mapNotNull { apiClient.callSummoner(it.summonerId) }
                .mapNotNull { apiClient.callMatches(it.puuid, 0, 400) }
                .map { dataService.filterIfExisted(it) }
                .transform { matchIds ->
                    matchIds.forEach { emit(it) }
                }
                .mapNotNull { apiClient.callMatch(it) }
                .collect { dataService.saveData(it) }

    }
}