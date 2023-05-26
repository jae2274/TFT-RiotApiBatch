package com.tft.apibatch.service

import com.tft.apibatch.entity.*
import com.tft.apibatch.repository.DeckRepository
import com.tft.apibatch.repository.IdSetRepository
import com.tft.apibatch.repository.TFTStatsRepository
import com.tft.apibatch.repository.WinnerDeckRepository
import org.springframework.stereotype.Service

@Service
class DataService(
    private val deckRepository: DeckRepository,
    private val winnerDeckRepository: WinnerDeckRepository,
    private val idSetRepository: IdSetRepository,
    private val tftStatsRepository: TFTStatsRepository,
) {

    fun isAlreadyHas(matchId: String): Boolean {
        return winnerDeckRepository.existsByMatch_id(matchId)
    }

    fun saveDecks(decks: List<Deck>) {
        deckRepository.saveAll(decks)
        decks.filter { it.placement == 1 }
            .map { WinnerDeck.of(it) }
            .let { winnerDeckRepository.saveAll(it) }
    }

    fun saveIdSets(idSets: Collection<IdSet>) {
        idSets
            .map { newIdSet ->
                idSetRepository.findBySeasonAndType(newIdSet.season, newIdSet.seasonNumber, newIdSet.type)
                    ?.let { alreadyIdSet -> alreadyIdSet.union(newIdSet) }
                    ?: newIdSet
            }
            .let { idSetRepository.saveAll(it) }
    }

    fun saveTftStats(tftStatsList: List<TftStats>) {
        tftStatsList
            .map { newTftStats ->
                tftStatsRepository.findByGameVersion(newTftStats.gameVersion)
                    ?.also { alreadyTftStats -> alreadyTftStats.add(newTftStats) }
                    ?: newTftStats
            }
            .let { tftStatsRepository.saveAll(it) }
    }

    fun findLastSavedDeck(): WinnerDeck =
        winnerDeckRepository.findTopByOrderByCreatedAtDesc()

}