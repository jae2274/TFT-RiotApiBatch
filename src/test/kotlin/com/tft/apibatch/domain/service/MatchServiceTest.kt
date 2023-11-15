package com.tft.apibatch.domain.service

import com.tft.apibatch.DynamoDBTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("local")
class MatchServiceTest(
    @Autowired
    private var matchService: MatchService
) : DynamoDBTest() {

    @Test
    fun existedMatchIdsEmpty() {
        val matchIds = listOf("matchId1", "matchId2", "matchId3", "matchId4")
        val excludedMatchIds = matchService.excludeExistedMatchIds(matchIds)

        Assertions.assertThat(excludedMatchIds).isEqualTo(matchIds)
    }

    @Test
    fun existedMatchIds() {
        val willSavedMatchIds = listOf("matchId1", "matchId3")
        willSavedMatchIds.forEach { matchId ->
            matchService.saveMatchId(matchId)
        }

        val matchIds = listOf("matchId1", "matchId2", "matchId3", "matchId4")
        val excludedMatchIds = matchService.excludeExistedMatchIds(matchIds)

        Assertions.assertThat(excludedMatchIds).isEqualTo(listOf("matchId2", "matchId4"))
    }
}