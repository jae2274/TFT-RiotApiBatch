package com.tft.apibatch.service

import com.tft.apibatch.api.RiotApiClient
import com.tft.apibatch.domain.service.DomainService
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import io.mockk.spyk
import io.mockk.verify
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
class AppServiceTest {

    @Autowired
    private lateinit var domainService: DomainService
    private lateinit var domainServiceSpy: DomainService

    @Autowired
    private lateinit var apiClient: RiotApiClient
    private lateinit var apiClientSpy: RiotApiClient

    private lateinit var appService: AppService

    @PostConstruct
    fun postConstruct() {
        apiClientSpy = spyk(apiClient)
        domainServiceSpy = spyk(domainService)

        appService = AppService(apiClientSpy, domainServiceSpy)
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
            coVerify(exactly = 5) { apiClientSpy.getPuuid(it) }
            coVerify(exactly = 5) { domainServiceSpy.saveSummoner(it, any()) }
        }
    }
}