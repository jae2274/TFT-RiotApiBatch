package com.tft.apibatch.feign

import org.springframework.cloud.openfeign.FeignClient
import com.tft.apibatch.feign.config.HeaderConfiguration
import com.tft.apibatch.feign.dto.MatchDTO
import org.springframework.web.bind.annotation.*

@FeignClient(
    name = "\${feign.tft.asiaApi.name}",
    url = "\${feign.tft.asiaApi.url}",
    configuration = [HeaderConfiguration::class]
)
interface AsiaApiClient {
    @RequestMapping(method = [RequestMethod.GET], value = ["/tft/match/v1/matches/by-puuid/{puuid}/ids"])
    fun callMatches(
        @RequestHeader("X-Riot-Token") xRiotToken: String,
        @PathVariable("puuid") puuid: String,
        @RequestParam("start") start: Int,
        @RequestParam("count") count: Int
    ): List<String>?

    @RequestMapping(method = [RequestMethod.GET], value = ["/tft/match/v1/matches/{matchId}"])
    fun callMatch(
        @RequestHeader("X-Riot-Token") xRiotToken: String,
        @PathVariable("matchId") matchId: String
    ): MatchDTO
}