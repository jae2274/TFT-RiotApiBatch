package com.tft.apibatch.feign

import com.tft.apibatch.feign.dto.LeagueListDTO
import com.tft.apibatch.feign.dto.MatchDTO
import com.tft.apibatch.feign.dto.SummonerDTO
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FeignTest {
    @Autowired
    lateinit var krApiClient :KrApiClient
    @Autowired
    lateinit var asiaApiClient: AsiaApiClient

    @Value("\${api-token}")
    lateinit var apiToken : String

    @Test
    fun callChallengerLeagues(){
        val leagueListDTO : LeagueListDTO? = krApiClient.callChallengerLeagues(apiToken)
        println(leagueListDTO)

        Assertions.assertThat(leagueListDTO).isNotNull


        val summonerDTO :SummonerDTO? = krApiClient.callSummoner(apiToken, leagueListDTO!!.entries!![0]!!.summonerId!!)
        println(summonerDTO)

        Assertions.assertThat(summonerDTO).isNotNull


        val callMatches : List<String>? = asiaApiClient.callMatches(apiToken, summonerDTO!!.puuid!!, 0, 100);
        println(callMatches)

        Assertions.assertThat(callMatches).isNotNull.isNotEmpty


        val matchDTO : MatchDTO? = asiaApiClient.callMatch(apiToken, callMatches!![0])
        println(matchDTO)

        Assertions.assertThat(matchDTO).isNotNull
    }

}