package com.tft.apibatch.domain.service

import com.tft.apibatch.DynamoDBTest
import com.tft.apibatch.config.DynamoDBConfig
import com.tft.apibatch.domain.entity.Summoner
import com.tft.apibatch.domain.repository.MatchRepository
import com.tft.apibatch.domain.repository.SummonerRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest(classes = [DomainService::class, SummonerRepository::class, MatchRepository::class, DynamoDBConfig::class])
class DomainServiceTest : DynamoDBTest() {
    @Autowired
    private lateinit var domainService: DomainService

    @Nested
    inner class TestSummoner {
        @Test
        fun existedSummonerEmpty() {
            val summonerIds = listOf("summonerId1", "summonerId2", "summonerId3", "summonerId4")
            val existedSummonersDTO = domainService.getExistedSummoners(summonerIds)

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
                domainService.saveSummoner(summoner.first, summoner.second)
            }

            val summonerIds = listOf("summonerId1", "summonerId2", "summonerId3", "summonerId4")
            val existedSummonersDTO = domainService.getExistedSummoners(summonerIds)

            Assertions.assertThat(willSavedSummoners)
                .containsExactlyInAnyOrderElementsOf(existedSummonersDTO.existedSummoners.map { it.summonerId to it.puuid })
            Assertions.assertThat(existedSummonersDTO.newSummonerIds).isEqualTo(listOf("summonerId2", "summonerId4"))
        }
    }

    @Nested
    inner class TestMatch {
        @Test
        fun existedMatchIdsEmpty() {
            val matchIds = listOf("matchId1", "matchId2", "matchId3", "matchId4")
            val excludedMatchIds = domainService.excludeExistedMatchIds(matchIds)

            Assertions.assertThat(excludedMatchIds).isEqualTo(matchIds)
        }

        @Test
        fun existedMatchIds() {
            val willSavedMatchIds = listOf("matchId1", "matchId3")
            willSavedMatchIds.forEach { matchId ->
                domainService.saveMatchId(matchId)
            }

            val matchIds = listOf("matchId1", "matchId2", "matchId3", "matchId4")
            val excludedMatchIds = domainService.excludeExistedMatchIds(matchIds)

            Assertions.assertThat(excludedMatchIds).isEqualTo(listOf("matchId2", "matchId4"))
        }
    }
}