package com.tft.apibatch

import com.tft.apibatch.api.RiotApiClient
import com.tft.apibatch.feign.dto.MatchDTO
import com.tft.apibatch.service.DataService
import com.tft.apibatch.support.util.SlackUtil
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class DataCollectScheduler(
    private val apiClient: RiotApiClient,
    private val dataService: DataService,
    private val slackUtil: SlackUtil,
) {

    @Scheduled(fixedDelay = 1000)
    fun collect() {
        sequenceFromApi()
            .forEach {
                try {
                    dataService.saveData(it)
                } catch (e: Exception) {
                    slackUtil.sendSlackMessage(e)
                }
            }

        println("test")
    }

    fun sequenceFromApi(): Sequence<MatchDTO> {
        return apiClient.callChallengerLeagues()
            ?.let { leagueListDTO ->
                val mapNotNull = leagueListDTO.entries
                    .asSequence()
                    .mapNotNull { apiClient.callSummoner(it.summonerId) }
                    .mapNotNull { apiClient.callMatches(it.puuid, 0, 400) }
                    .flatMap { dataService.filterIfExisted(it) }
                    .mapNotNull { apiClient.callMatch(it) }
                mapNotNull
            } ?: emptySequence()
    }
}