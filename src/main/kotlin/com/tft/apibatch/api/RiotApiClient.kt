package com.tft.apibatch.api

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.type.TypeFactory
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.tft.apibatch.actor.ApiRequest
import com.tft.apibatch.api.dto.LeagueListDTO
import com.tft.apibatch.api.dto.MatchDTO
import com.tft.apibatch.api.dto.SummonerDTO
import com.tft.apibatch.service.ApiService
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component

@Component
class RiotApiClient(
        @Value("\${feign.tft.asiaApi.url}")
        private val asiaApiUrl: String,
        @Value("\${feign.tft.krApi.url}")
        private val krApiUrl: String,
        @Value("\${api-token}")
        val apiToken: String,
        val apiService: ApiService,
) {
    private val objectMapper =
            jacksonObjectMapper().registerKotlinModule().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)


    fun callChallengerLeagues(): LeagueListDTO? {
        val request = ApiRequest(
                method = HttpMethod.GET,
                url = "$krApiUrl/tft/league/v1/challenger",
                headers = listOf(Pair("X-Riot-Token", apiToken))
        )

        return apiService.callApi(request, false)
                .let {
                    objectMapper.readValue(it, LeagueListDTO::class.java)
                }
    }

    fun callSummoner(summerId: String): SummonerDTO? {

        val request = ApiRequest(
                method = HttpMethod.GET,
                url = "$krApiUrl/tft/summoner/v1/summoners/{encryptedSummerId}",
                pathVariables = listOf(summerId),
                headers = listOf(Pair("X-Riot-Token", apiToken))
        )

        return apiService.callApi(request, true)
                ?.let {
                    objectMapper.readValue(it, SummonerDTO::class.java)
                }
    }

    fun callMatches(puuid: String, start: Int, count: Int): List<String>? {
        val request = ApiRequest(
                method = HttpMethod.GET,
                url = "$asiaApiUrl/tft/match/v1/matches/by-puuid/{puuid}/ids",
                pathVariables = listOf(puuid),
                queryParams = listOf(Pair("start", start), Pair("count", count)),
                headers = listOf(Pair("X-Riot-Token", apiToken))
        )

        return apiService.callApi(request, false)
                ?.let {
                    val javaType =
                            TypeFactory.defaultInstance().constructCollectionType(List::class.java, String::class.java)
                    objectMapper.readValue(it, javaType)
                }
    }

    fun callMatch(matchId: String): MatchDTO? {
        val request = ApiRequest(
                method = HttpMethod.GET,
                url = "$asiaApiUrl/tft/match/v1/matches/{matchId}",
                pathVariables = listOf(matchId),
                headers = listOf(Pair("X-Riot-Token", apiToken))
        )

        return apiService.callApi(request, true)
                ?.let {
                    objectMapper.readValue(it, MatchDTO::class.java)
                }
    }

}