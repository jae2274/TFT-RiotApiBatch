package com.tft.apibatch.batch

import com.tft.apibatch.entry.*
import com.tft.apibatch.feign.AsiaApiClient
import com.tft.apibatch.feign.KrApiClient
import com.tft.apibatch.repository.*
import com.tft.apibatch.service.DataService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class NewCollector(
        @Value("\${api-token}")
        private val apiToken: String,
        private val krApiClient: KrApiClient,
        private val asiaApiClient: AsiaApiClient,
        private val dataService: DataService
) {
    fun collectData(wantMatchCount: Int) {

        while (true) {
            try {
                krApiClient.callChallengerLeagues(apiToken)?.run {
                    this.entries
                            .asSequence()
                            .mapNotNull { krApiClient.callSummoner(apiToken, it.summonerId) }
                            .mapNotNull { asiaApiClient.callMatches(apiToken, it.puuid, 0, 200) }
                            .flatMap { it }
                            .mapNotNull { asiaApiClient.callMatch(apiToken, it) }
                            .forEach { dataService.saveData(it) }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}