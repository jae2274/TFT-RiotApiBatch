package com.tft.apibatch.batch

import com.tft.apibatch.api.RiotApiClient
import com.tft.apibatch.feign.dto.MatchDTO
import com.tft.apibatch.service.DataService
import kotlinx.coroutines.flow.*
import org.springframework.stereotype.Component

@Component
class DataCollector(
        private val apiClient: RiotApiClient,
        private val dataService: DataService
) {
    fun flowFromApi(): Flow<MatchDTO> {
        return flow {
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
    }

    suspend fun collect() {
        flowFromApi()
                .onEach {
                    try {
                        dataService.saveData(it)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                .collect()
    }
}