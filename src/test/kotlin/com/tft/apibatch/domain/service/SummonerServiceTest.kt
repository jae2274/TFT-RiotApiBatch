package com.tft.apibatch.domain.service

import com.tft.apibatch.DynamoDBTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles


@SpringBootTest
@ActiveProfiles("local")
class SummonerServiceTest(
    @Autowired
    private var summonerService: SummonerService
) : DynamoDBTest() {
    @Test
    fun existedSummonerEmpty() {
        val summonerIds = listOf("summonerId1", "summonerId2", "summonerId3", "summonerId4")
        val existedSummonersDTO = summonerService.getExistedSummoners(summonerIds)

        Assertions.assertThat(existedSummonersDTO.existedSummoners).isEmpty()
        Assertions.assertThat(existedSummonersDTO.newSummonerIds).isEqualTo(summonerIds)
    }

    @Test
    fun existedSummoners() {
        val willSavedSummoners = listOf(
            "summonerId1" to "puuid1",
            "summonerId3" to "puuid3",
        )

        willSavedSummoners.forEach { summoner ->
            summonerService.saveSummoner(summoner.first, summoner.second)
        }

        val summonerIds = listOf("summonerId1", "summonerId2", "summonerId3", "summonerId4")
        val existedSummonersDTO = summonerService.getExistedSummoners(summonerIds)

        Assertions.assertThat(willSavedSummoners)
            .containsExactlyInAnyOrderElementsOf(existedSummonersDTO.existedSummoners.map { it.summonerId to it.puuid })
        Assertions.assertThat(existedSummonersDTO.newSummonerIds).isEqualTo(listOf("summonerId2", "summonerId4"))
    }
}