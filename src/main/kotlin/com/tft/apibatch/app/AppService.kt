package com.tft.apibatch.app

import com.tft.apibatch.api.RiotApiClient
import com.tft.apibatch.api.SummonerTier
import com.tft.apibatch.api.dto.MatchResponse
import com.tft.apibatch.domain.service.MatchService
import com.tft.apibatch.domain.service.SummonerService
import com.tft.apibatch.domain.service.TftVersionService
import org.springframework.stereotype.Service

@Service
class AppService(
    private val apiClient: RiotApiClient,
    private val summonerService: SummonerService,
    private val matchService: MatchService,
    private val versionService: TftVersionService
) {
    suspend fun getSummonerIds(needSummonerCount: Int): List<String> {
        return getSummonerIdsEntry(needSummonerCount).take(needSummonerCount)
    }

    suspend fun getPuuids(summonerIds: Iterable<String>): List<String> {
        val existedSummonersDTO = summonerService.getExistedSummoners(summonerIds)

        val newSummoners = existedSummonersDTO.newSummonerIds.map { newSummonerId ->
            val puuid = apiClient.getSummoner(newSummonerId).puuid
            summonerService.saveSummoner(newSummonerId, puuid)
        }

        return (newSummoners + existedSummonersDTO.existedSummoners)
            .map { it.puuid }
    }


    suspend fun getMatchIds(puuid: String, start: Int, count: Int): List<String> {
        val matchIds = apiClient.getMatchIds(puuid, start, count)

        return matchService.excludeExistedMatchIds(matchIds)
    }

    suspend fun getMatch(matchId: String): MatchResponse {
        return apiClient.getMatch(matchId)
    }


    suspend fun isLatest(version: String): Boolean {
        versionService.updateVersionIfMoreLatest(version)
        return versionService.isLatest(version)
    }

    private suspend fun getSummonerIdsEntry(
        needSummonerCount: Int,
        summonerTiers: ArrayDeque<SummonerTier> = ArrayDeque(SummonerTier.values().toList()),
        summonerIds: MutableSet<String> = mutableSetOf()
    ): Set<String> {
        val needSummonerCount = needSummonerCount - summonerIds.size
        val summonerTier = summonerTiers.removeFirstOrNull()

        if (needSummonerCount > 0 && summonerTier != null) {
            apiClient.getSummoners(summonerTier)
                .let { leagueListRes -> leagueListRes.entries.map { it.summonerId } }
                .let { summonerIds.addAll(it) }

            return getSummonerIdsEntry(needSummonerCount, summonerTiers, summonerIds)
        } else
            return summonerIds
    }
}