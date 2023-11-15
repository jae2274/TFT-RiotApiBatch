package com.tft.apibatch.app

import com.tft.apibatch.DynamoDBTest
import com.tft.apibatch.api.RiotApiClient
import com.tft.apibatch.domain.service.MatchService
import com.tft.apibatch.domain.service.SummonerService
import io.mockk.coVerify
import io.mockk.junit5.MockKExtension
import io.mockk.spyk
import jakarta.annotation.PostConstruct
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.*
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles


@SpringBootTest
@ActiveProfiles("local")
@ExtendWith(MockKExtension::class)
class AppServiceTest : DynamoDBTest() {

    @Autowired
    private lateinit var domainService: SummonerService
    private lateinit var summonerServiceSpy: SummonerService

    @Autowired
    private lateinit var matchService: MatchService

    @Autowired
    private lateinit var apiClient: RiotApiClient
    private lateinit var apiClientSpy: RiotApiClient

    private lateinit var appService: AppService

    @PostConstruct
    fun postConstruct() {
        apiClientSpy = spyk(apiClient)
        summonerServiceSpy = spyk(domainService)

        appService = AppService(apiClientSpy, summonerServiceSpy, matchService)
    }

    @Test
    fun testGetSummonerIdsCount() = runTest {
        val summonerIds = appService.getSummonerIds(800)

        Assertions.assertThat(summonerIds).hasSize(800)
    }

    @Test
    fun testGetSummonerIdsCount2() = runTest {
        val summonerIds = appService.getSummonerIds(5)

        Assertions.assertThat(summonerIds).hasSize(5)
    }

    @Test
    fun test() = runTest {
        val summonerIds = appService.getSummonerIds(5)

        val puuids = appService.getPuuids(summonerIds)

        Assertions.assertThat(puuids).hasSize(5)

        summonerIds.forEach {
            coVerify(exactly = 1) { apiClientSpy.getSummoner(it) }
            coVerify(exactly = 1) { summonerServiceSpy.saveSummoner(it, any()) }
        }
    }
}