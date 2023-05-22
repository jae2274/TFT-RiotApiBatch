package com.tft.apibatch.service

import com.github.benmanes.caffeine.cache.Caffeine
import com.tft.apibatch.actor.ApiRequest
import org.springframework.boot.autoconfigure.cache.CacheProperties
import java.util.concurrent.TimeUnit

class CacheService {
    private val cache = Caffeine.newBuilder()
            .expireAfterAccess(12, TimeUnit.HOURS)
            .build<ApiRequest, String?>()

    fun getIfPresent(request: ApiRequest): String? {
        return cache.getIfPresent(request)
    }

    fun put(request: ApiRequest, response: String) {
        cache.put(request, response)
    }
}