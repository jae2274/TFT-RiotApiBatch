package com.tft.apibatch

import com.tft.apibatch.api.RiotApiClient
import com.tft.apibatch.api.SummonerTier
import com.tft.apibatch.api.dto.LeagueListDTO
import com.tft.apibatch.api.dto.MatchDTO
import com.tft.apibatch.entity.Deck
import com.tft.apibatch.entity.IdSet
import com.tft.apibatch.entity.TftStats
import com.tft.apibatch.entity.listOf
import com.tft.apibatch.service.DataService
import com.tft.apibatch.support.util.SlackUtil
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class DataCollectScheduler(
    private val apiClient: RiotApiClient,
    private val dataService: DataService,
    private val slackUtil: SlackUtil,
) {

    @Scheduled(fixedDelay = 1000)
    fun collect() {
        try {
            sequenceMatchDTOFromApi()
                .forEach { matchDTO ->
                    if (!dataService.isAlreadyHas(matchDTO.metadata.match_id)) {
                        val decks = Deck.listOf(matchDTO)
                        val idSets = IdSet.listOf(decks)
                        val tftStatsList = TftStats.listOf(decks)

                        dataService.saveDecks(decks)
                        dataService.saveIdSets(idSets)
                        dataService.saveTftStats(tftStatsList)
                    }
                }
        } catch (e: Exception) {
            e.printStackTrace()
            slackUtil.sendSlackMessage(e)
        }
    }


    fun sequenceMatchDTOFromApi(): Sequence<MatchDTO> {
        return callSummonerEntries()
            .asSequence()
            .map { apiClient.callSummoner(it.summonerId) }
            .flatMap { apiClient.callMatches(it.puuid, 0, 30) }
            .map { matchId -> apiClient.callMatch(matchId) }
    }

    private fun callSummonerEntries(
        summonerTiers: ArrayDeque<SummonerTier> = ArrayDeque(SummonerTier.values().toList()),
        entries: MutableList<LeagueListDTO.LeagueItemDTO> = mutableListOf()
    ): List<LeagueListDTO.LeagueItemDTO> {
        val needMoreCount = 20 - entries.size
        val summonerTier = summonerTiers.removeFirstOrNull()

        if (needMoreCount > 0 && summonerTier != null) {
            apiClient.callSummoners(summonerTier).entries
                .let { entries.addAll(it) }

            return callSummonerEntries(summonerTiers, entries)
        } else
            return entries
    }
}