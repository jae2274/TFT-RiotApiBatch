package com.tft.apibatch.api

import com.tft.apibatch.actor.ApiActor
import com.tft.apibatch.actor.ApiRequest
import com.tft.apibatch.service.ApiService
import com.tft.apibatch.service.CacheService
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.http.HttpMethod


@DisplayName("ApiService 내부에서 실제 api호출과 캐싱의 동작을 테스트")
class CacheTestForApiService {
    companion object {
        val request = ApiRequest(
                method = HttpMethod.GET,
                url = "testUrl/{testId}",
                pathVariables = listOf("testId"),
        )
        val expectedResponse = """{answer:"test!"}"""

        val anotherRequest = ApiRequest(
                method = HttpMethod.GET,
                url = "testUrl/{testId}",
                pathVariables = listOf("anotherTestId"),
        )
        val anotherExpectedResponse = """{answer:"anotherAnswer!"}"""
    }

    @Nested
    @DisplayName("캐싱하는 케이스")
    class NeedCacheCases {
        @Test
        @DisplayName("어떤 캐시도 존재하지 않은 상황에서 호출할 경우, 실제 api호출을 하며, 캐시에 저장한다")
        fun any_cached_existed() = runTest {
            val (apiActor, cacheService, apiService) = createMocks()
            every { apiActor.process(request) } returns createReceiveChannel(expectedResponse)

            val response = runBlocking { apiService.callApi(request, true) }

            Assertions.assertThat(response).isEqualTo(expectedResponse)
            verify(exactly = 1) { apiActor.process(any()) }
            verify(exactly = 1) { cacheService.put(any(), any()) }
        }

        @Test
        @DisplayName("request에 대한 api호출 결과가 캐싱되 있는 경우, 실제 api호출은 발생하지 않는다.")
        fun cache_existed() = runTest {
            val (apiActor, cacheService, apiService) = createMocks(request, expectedResponse)
            every { apiActor.process(request) } returns createReceiveChannel(expectedResponse)

            val response = runBlocking { apiService.callApi(request, true) }

            Assertions.assertThat(response).isEqualTo(expectedResponse)
            verify(exactly = 0) { apiActor.process(any()) }
            verify(exactly = 0) { cacheService.put(any(), any()) }
        }

        @Test
        @DisplayName("신규 request에 대한 호출은 캐싱이 없으므로 실제api호출이 발생한다.")
        fun cache_existed_but_different() = runTest {
            val (apiActor, cacheService, apiService) = createMocks(request, expectedResponse)
            every { apiActor.process(anotherRequest) } returns createReceiveChannel(anotherExpectedResponse)

            val response = runBlocking { apiService.callApi(anotherRequest, true) }

            Assertions.assertThat(response).isEqualTo(anotherExpectedResponse)
            verify(exactly = 1) { apiActor.process(any()) }
            verify(exactly = 1) { cacheService.put(any(), any()) }
        }
    }

    @Nested
    @DisplayName("캐싱하지 않는 케이스: 캐싱 여부와 관계없이 실제 api를 호출하며, 캐시에 저장하지 않는다")
    class NotCachingCase {
        @Test
        fun any_cached_existed() = runTest {
            val (apiActor, cacheService, apiService) = createMocks()
            every { apiActor.process(request) } returns createReceiveChannel(expectedResponse)

            val response = runBlocking { apiService.callApi(request, false) }

            Assertions.assertThat(response).isEqualTo(expectedResponse)
            verify(exactly = 1) { apiActor.process(any()) }
            verify(exactly = 0) { cacheService.put(any(), any()) }
        }

        @Test
        fun cache_existed() = runTest {
            val (apiActor, cacheService, apiService) = createMocks(request, expectedResponse)
            every { apiActor.process(request) } returns createReceiveChannel(expectedResponse)

            val response = runBlocking { apiService.callApi(request, false) }

            Assertions.assertThat(response).isEqualTo(expectedResponse)
            verify(exactly = 1) { apiActor.process(any()) }
            verify(exactly = 0) { cacheService.put(any(), any()) }
        }

        @Test
        fun cache_existed_but_different() = runTest {
            val (apiActor, cacheService, apiService) = createMocks(request, expectedResponse)
            every { apiActor.process(anotherRequest) } returns createReceiveChannel(anotherExpectedResponse)

            val response = runBlocking { apiService.callApi(anotherRequest, false) }

            Assertions.assertThat(response).isEqualTo(anotherExpectedResponse)
            verify(exactly = 1) { apiActor.process(any()) }
            verify(exactly = 0) { cacheService.put(any(), any()) }
        }
    }
}

private fun createMocks(key: ApiRequest, value: String) = createMocks(listOf(key to value))


private fun createMocks(alreadyCachedList: List<Pair<ApiRequest, String>> = emptyList()): Triple<ApiActor, CacheService, ApiService> {
    val apiActor = mockk<ApiActor>()
    val cacheService = CacheService()
            .also { alreadyCachedList.forEach { (request, response) -> it.put(request, response) } }
            .let { spyk(it) }
    val apiService = ApiService(cacheService, apiActor)

    return Triple(apiActor, cacheService, apiService)
}

private fun createReceiveChannel(response: String): ReceiveChannel<Result<String?>> {
    return runBlocking {
        Channel<Result<String?>>(1)
                .also { it.send(Result.success(response)) }
    }
}