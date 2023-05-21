package com.tft.apibatch.actor

import com.tft.apibatch.support.util.MyActor
import kotlinx.coroutines.delay
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder

@Component
class ApiActor(
        @Value("\${break-time}")
        val breakTime: Long
):MyActor<ApiRequest,String?>({ apiRequest ->
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

    WebClient.create()
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
    .bodyToMono(String::class.java)
    .block()
    .let {
        delay(breakTime)
        it
    }
} )


data class ApiRequest(
        val url: String,
        val method: HttpMethod,
        val pathVariables: List<String> = emptyList(),
        val queryParams: List<Pair<String, Any>> = emptyList(),
        val body: Any? = null,
        val headers: List<Pair<String, String>> = emptyList(),
)