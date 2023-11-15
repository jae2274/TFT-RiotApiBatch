package com.tft.apibatch.actor

import com.tft.apibatch.support.util.MyActor
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.util.UriComponentsBuilder

@Component
class ApiActor(
    @Value("\${api-token}")
    private val apiToken: String,
    @Value("\${break-time}")
    val breakTime: Long
) : MyActor<ApiRequest, String>() {
    private val riotApi: WebClient = WebClient.builder()
        .defaultHeader("X-Riot-Token", apiToken)
        .build()

    suspend fun callApi(request: ApiRequest): String {
        val self = this
        return self.process(request).receive().getOrThrow()
    }


    override suspend fun processMessage(apiRequest: ApiRequest): String {
        val uri = UriComponentsBuilder.fromUriString(apiRequest.url)
            .let { uriComponentsBuilder ->
                apiRequest.queryParams.fold(uriComponentsBuilder) { builder, pair ->
                    builder.queryParam(
                        pair.first,
                        pair.second
                    )
                }
            }
            .buildAndExpand(*apiRequest.pathVariables.toTypedArray())
            .toUri()

        return riotApi
            .method(apiRequest.method)
            .uri(uri)
            .let { webClient ->
                if (apiRequest.body != null)
                    webClient.bodyValue(apiRequest.body)
                else
                    webClient
            }
            .let { webClient ->
                apiRequest.headers.fold(webClient) { client, pair -> client.header(pair.first, pair.second) }
            }
            .retrieve()
            .awaitBody<String>()
            .let {
                delay(breakTime)
                it
            }
    }
}


data class ApiRequest(
    val url: String,
    val method: HttpMethod,
    val pathVariables: List<String> = emptyList(),
    val queryParams: List<Pair<String, Any>> = emptyList(),
    val body: Any? = null,
    val headers: List<Pair<String, String>> = emptyList(),
)