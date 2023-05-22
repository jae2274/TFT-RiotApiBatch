package com.tft.apibatch.service

import com.tft.apibatch.actor.ApiActor
import com.tft.apibatch.actor.ApiRequest
import com.tft.apibatch.support.util.MyActor
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class ApiService(
        private val cacheService: CacheService,
        private val apiActor: MyActor<ApiRequest, String?>,
) {

    fun callApi(request: ApiRequest, isCaching: Boolean): String {
        return runBlocking {
            if (isCaching) {
                cacheService.getIfPresent(request)
                        ?: apiActor.process(request).receive().getOrThrow()!!
                                .also { cacheService.put(request, it) }
            } else {
                apiActor.process(request).receive().getOrThrow()!!
            }
        }
    }
}