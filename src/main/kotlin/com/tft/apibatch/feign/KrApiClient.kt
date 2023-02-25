package com.tft.apibatch.feign

import com.tft.apibatch.feign.config.HeaderConfiguration
import com.tft.apibatch.feign.dto.LeagueListDTO
import com.tft.apibatch.feign.dto.SummonerDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(
        name = "\${feign.tft.krApi.name}",
        url = "\${feign.tft.krApi.url}",
        configuration = [HeaderConfiguration::class]
)
interface KrApiClient {
    @RequestMapping(method = [RequestMethod.GET], value = ["/tft/league/v1/challenger"])
    fun callChallengerLeagues(
            @RequestHeader("X-Riot-Token") xRiotToken: String,
    ): LeagueListDTO?

    @RequestMapping(method = [RequestMethod.GET], value = ["/tft/summoner/v1/summoners/{encryptedSummerId}"])
    fun callSummoner(
            @RequestHeader("X-Riot-Token") xRiotToken: String,
            @PathVariable("encryptedSummerId") summerId: String
    ): SummonerDTO?
}