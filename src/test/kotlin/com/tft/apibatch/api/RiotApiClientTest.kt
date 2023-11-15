package com.tft.apibatch.api

import com.tft.apibatch.actor.ApiActor
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles


@ActiveProfiles("local")
@SpringBootTest(classes = [RiotApiClient::class, ApiActor::class])
@DisplayName("riot api를 호출하여 결과를 확인한다. api호출마다 결과가 동적인 것과 그렇지 않은 것이 있다.")
class RiotApiClientTest(
    @Autowired
    private val riotApiClient: RiotApiClient
) {

    companion object {
        private val summonerIds = setOf(
            "-QmcMmwuN79OoArUjT3PPBob_C2d2yJJezKwIaKPnGn3g7A",
            "IRCkHx4yZZ_-eow8aQJiVkYBIAl_3W6FHEBNCa6TPllnxw",
            "-pVS-PpnDMVJN9uoXBnuf2z3zqDunrIh5XmNQC5f-u8zXYKX3eNS-msDdQ",
            "IFySKGTwkrQ-_LhRXKxdn7WJLI0uw5f69rp0NFIY_p_ERCY",
            "pNk6MXi3XfYL8uKvsCkOj320FGVylTh1rYwd0FSQ7GRuvYo",
        )

        private val puuids = listOf(
            "9KKWkgljt2drURcBejbE-NBU4reBpGWkisNSdaYeGtP7vXPQYhRwrr3EMJxk-2P-jjKjlsqbU7Ov8A",
            "55ftrb1u4f1zd134l-Noem1fTwIR3JyJ6e8bTE7iwmSvHld-h4VKSgS2DLOSJSi04lsY25E6CS_7EQ",
            "N0BbREeLvuus-ClDcOlVkkUZQvBGM85li9TKJXOJ__c7QReVhxBzhTxKmUGPIyNGk7EgZy3R2ayF5A",
            "rdOnXjKeb2qSu4goYEcz-pJY4ihNSBkohtlBmZ93ZoXjbBzLw3hZ1jy3bJREri0t5X8V9BIvs3qCDQ",
            "OqS-e-8dSvsosSLMYSqf-y9uA0DIYg3GfKPoWYKgQeTuwlfGl3vC4s-jiV4F6EdWXruhMLpIh9vl3A"
        )
    }

    @Test
    @DisplayName("챌린저 랭커의 summonerid 목록 api를 호출한다.")
    fun callChallengerLeagues() = runTest {
        val leagueListDTO = riotApiClient.getSummoners(SummonerTier.challenger)

        assertThat(leagueListDTO).isNotNull
        checkNotNull(leagueListDTO)
        assertThat(leagueListDTO.entries).isNotEmpty
        assertThat(leagueListDTO.tier).isEqualTo("CHALLENGER")
    }

    @Test
    @DisplayName("summonerid로 puuid를 알아낼 수 있는 api를 호출한다.")
    fun callSummoner() = runTest {
        val failedCalls = mutableSetOf<String>()

        val summonerDTOS = summonerIds.mapNotNull { summonerId ->
            riotApiClient.getSummoner(summonerId).also { if (it == null) failedCalls.add(summonerId) }
        }

        assertThat(failedCalls).isEmpty()
        assertThat(summonerDTOS.map { it.puuid }).isEqualTo(puuids)
    }

    @Test
    @DisplayName("puuid로 matchid를 알아낼 api를 호출 후, matchid로 경기데이터api를 호출한다.")
    fun callMatches() = runTest {
        val failedCallPuuIds = mutableSetOf<String>()
        val failedCallMatchIds = mutableSetOf<String>()


        val matchIds = puuids
            .mapNotNull { puuid ->
                riotApiClient.getMatchIds(puuid, 0, 3).also { if (it == null) failedCallPuuIds.add(puuid) }
            }.flatten()
            .toSet()

        val matchDTOs = matchIds.mapNotNull { matchId ->
            riotApiClient.getMatch(matchId).also { if (it == null) failedCallMatchIds }
        }

        assertAll(
            { assertThat(failedCallPuuIds).isEmpty() },
            { assertThat(failedCallMatchIds).isEmpty() },
        )
    }
}