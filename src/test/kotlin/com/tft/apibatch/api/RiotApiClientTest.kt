package com.tft.apibatch.api

import com.tft.apibatch.config.JasyptConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles


@ActiveProfiles("local")
@SpringBootTest(classes = [RiotApiClient::class, ActorConfig::class, JasyptConfig::class])
class RiotApiClientTest(
    @Autowired
    private val riotApiClient: RiotApiClient,
) {


    @Test
    fun callChallengerLeagues() {
        val leagueListDTO = riotApiClient.callChallengerLeagues()

        assertThat(leagueListDTO).isNotNull
        checkNotNull(leagueListDTO)
        assertThat(leagueListDTO.entries).isNotEmpty
        assertThat(leagueListDTO.tier).isEqualTo("CHALLENGER")
    }

    @Test
    fun callSummoner() {
        val summonerIds = setOf(
            "-QmcMmwuN79OoArUjT3PPBob_C2d2yJJezKwIaKPnGn3g7A",
            "IRCkHx4yZZ_-eow8aQJiVkYBIAl_3W6FHEBNCa6TPllnxw",
            "-pVS-PpnDMVJN9uoXBnuf2z3zqDunrIh5XmNQC5f-u8zXYKX3eNS-msDdQ",
            "IFySKGTwkrQ-_LhRXKxdn7WJLI0uw5f69rp0NFIY_p_ERCY",
            "pNk6MXi3XfYL8uKvsCkOj320FGVylTh1rYwd0FSQ7GRuvYo",
        )

        val puuids = listOf(
            "9KKWkgljt2drURcBejbE-NBU4reBpGWkisNSdaYeGtP7vXPQYhRwrr3EMJxk-2P-jjKjlsqbU7Ov8A",
            "55ftrb1u4f1zd134l-Noem1fTwIR3JyJ6e8bTE7iwmSvHld-h4VKSgS2DLOSJSi04lsY25E6CS_7EQ",
            "N0BbREeLvuus-ClDcOlVkkUZQvBGM85li9TKJXOJ__c7QReVhxBzhTxKmUGPIyNGk7EgZy3R2ayF5A",
            "rdOnXjKeb2qSu4goYEcz-pJY4ihNSBkohtlBmZ93ZoXjbBzLw3hZ1jy3bJREri0t5X8V9BIvs3qCDQ",
            "OqS-e-8dSvsosSLMYSqf-y9uA0DIYg3GfKPoWYKgQeTuwlfGl3vC4s-jiV4F6EdWXruhMLpIh9vl3A"
        )

        val failedCalls = mutableSetOf<String>()

        val summonerDTOS = summonerIds.mapNotNull { summonerId ->
            riotApiClient.callSummoner(summonerId).also { if (it == null) failedCalls.add(summonerId) }
        }

        assertThat(failedCalls).isEmpty()
        assertThat(summonerDTOS.map { it.puuid }).isEqualTo(puuids)

    }

    @Test
    fun callMatches() {
    }

    @Test
    fun callMatch() {
    }
}