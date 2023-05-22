package com.tft.apibatch.service

import com.tft.apibatch.actor.ApiRequest
import com.tft.apibatch.support.util.MyActor


class ApiService(
        private val cacheService: CacheService,
        private val apiActor: MyActor<ApiRequest, String?>,
) {

    suspend fun callApi(request: ApiRequest, isCaching: Boolean): String {
        return if (isCaching) {
            cacheService.getIfPresent(request)
                    ?: apiActor.process(request).receive().getOrThrow()!!
                            .also { cacheService.put(request, it) }
        } else {
            apiActor.process(request).receive().getOrThrow()!!
        }
    }
}