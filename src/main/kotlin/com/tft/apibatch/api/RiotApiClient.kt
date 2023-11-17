package com.tft.apibatch.api

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.type.TypeFactory
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.tft.apibatch.actor.ApiActor
import com.tft.apibatch.actor.ApiRequest
import com.tft.apibatch.api.dto.LeagueListResponse
import com.tft.apibatch.api.dto.SummonerResponse
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
    val apiActor: ApiActor,
) {
    private val objectMapper =
        jacksonObjectMapper().registerKotlinModule().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)


    suspend fun getSummoners(tier: SummonerTier): LeagueListResponse {
        val request = ApiRequest(
            method = HttpMethod.GET,
            url = "$krApiUrl/tft/league/v1/$tier",
            headers = listOf(Pair("X-Riot-Token", apiToken))
        )

        return apiActor.callApi(request)
            .let {
                objectMapper.readValue(it, LeagueListResponse::class.java)
            }
    }

    suspend fun getSummoner(summerId: String): SummonerResponse {

        val request = ApiRequest(
            method = HttpMethod.GET,
            url = "$krApiUrl/tft/summoner/v1/summoners/{encryptedSummerId}",
            pathVariables = listOf(summerId),
            headers = listOf(Pair("X-Riot-Token", apiToken))
        )

        return apiActor.callApi(request)
            .let {
                objectMapper.readValue(it, SummonerResponse::class.java)
            }
    }

    suspend fun getMatchIds(puuid: String, start: Int, count: Int, startTime: Long? = null): List<String> {
        val request = ApiRequest(
            method = HttpMethod.GET,
            url = "$asiaApiUrl/tft/match/v1/matches/by-puuid/{puuid}/ids",
            pathVariables = listOf(puuid),
            queryParams = mutableListOf<Pair<String, Any>>(Pair("start", start), Pair("count", count))
                .also { list ->
                    startTime?.let { list.add(Pair("startTime", startTime)) }
                },
            headers = listOf(Pair("X-Riot-Token", apiToken))
        )

        return apiActor.callApi(request)
            .let {
                val javaType =
                    TypeFactory.defaultInstance().constructCollectionType(List::class.java, String::class.java)
                objectMapper.readValue(it, javaType)
            }
    }

    suspend fun getMatch(matchId: String): String {
        val request = ApiRequest(
            method = HttpMethod.GET,
            url = "$asiaApiUrl/tft/match/v1/matches/{matchId}",
            pathVariables = listOf(matchId),
            headers = listOf(Pair("X-Riot-Token", apiToken))
        )

        return apiActor.callApi(request)
    }
}

enum class SummonerTier {
    challenger, grandmaster, master
}