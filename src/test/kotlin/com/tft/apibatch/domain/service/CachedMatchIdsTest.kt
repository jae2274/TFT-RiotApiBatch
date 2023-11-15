package com.tft.apibatch.domain.service

import com.tft.apibatch.DynamoDBTest
import com.tft.apibatch.domain.entity.Match
import com.tft.apibatch.domain.repository.MatchRepository
import io.mockk.spyk
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("local")
class CachedMatchIdsTest(
    @Autowired
    private var matchRepository: MatchRepository,
) : DynamoDBTest() {
    private val spyMatchRepository: MatchRepository = spyk(matchRepository)
    private val cachedMatchIds = mutableSetOf<String>()
    private var matchService: MatchService = MatchService(
        spyMatchRepository,
        cachedMatchIds
    )

    @Test
    fun emptyWhenNoActions() {
        Assertions.assertThat(cachedMatchIds).isEmpty()
    }

    @Test
    fun cachedWhenSave() {
        val matchId = "matchId1"
        matchService.saveMatchId(matchId)

        Assertions.assertThat(cachedMatchIds).isEqualTo(setOf(matchId))
    }

    @Test
    fun cachedIfMatchIdsExisted() {
        val savedMatchIds = listOf("matchId1", "matchId3")
        savedMatchIds.forEach { matchId ->
            matchRepository.save(Match(matchId, System.currentTimeMillis()))
        }
        Assertions.assertThat(cachedMatchIds).isEmpty() //단순 체크용

        val matchIds = listOf("matchId1", "matchId2", "matchId3", "matchId4")
        matchService.excludeExistedMatchIds(matchIds)// 이 때 이미 DB에 저장된 matchId1, matchId3가 cachedMatchIds에 저장됨

        Assertions.assertThat(cachedMatchIds).isEqualTo(savedMatchIds.toSet())
        verify(exactly = 1) { spyMatchRepository.findAllById(any()) }
    }

    @Test
    fun didntFindWhenAlreadyAllCached() {
        val savedMatchIds = listOf("matchId1", "matchId2", "matchId3", "matchId4")
        cachedMatchIds.addAll(savedMatchIds)

        matchService.excludeExistedMatchIds(savedMatchIds)
        verify(exactly = 0) { spyMatchRepository.findAllById(any()) }
    }
}
