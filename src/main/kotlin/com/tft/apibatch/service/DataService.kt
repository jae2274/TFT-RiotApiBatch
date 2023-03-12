package com.tft.apibatch.service

import com.tft.apibatch.entry.*
import com.tft.apibatch.feign.dto.MatchDTO
import com.tft.apibatch.repository.DeckRepository
import com.tft.apibatch.repository.IdSetRepository
import com.tft.apibatch.repository.MatchRepository
import com.tft.apibatch.repository.WinnerDeckRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DataService(
        private val matchRepository: MatchRepository,
        private val deckRepository: DeckRepository,
        private val winnerDeckRepository: WinnerDeckRepository,
        private val idSetRepository: IdSetRepository,
) {

    fun filterIfExisted(matchIds: List<String>): List<String> {
        return matchRepository.findAllById(matchIds)
                .map { it.match_id }
                .toSet()
                .let { existedIds ->
                    matchIds.filterNot { existedIds.contains(it) }
                }
    }

    @Transactional//mongoDB standalone에서는 트랜잭션은 작동하지 않는다
    fun saveData(matchDTO: MatchDTO) {
        val decks = Deck.listOf(matchDTO)
        deckRepository.saveAll(decks)

        decks.minByOrNull { it.placement }!!
                .apply { winnerDeckRepository.save(WinnerDeck.of(this)) }

        matchRepository.save(Match.of(matchDTO))

        val units = decks.flatMap { it.units }

        val season = decks.first().info.tft_set_core_name
        val seasonNumber = decks.first().info.tft_set_number


        val idSets = idSetRepository.findBySeason(season)

        val idSetsByType: MutableMap<IdType, IdSet> = idSets.associateBy({ it.type }, { it }).toMutableMap()

        val championIds = units.map { it.character_id }.toSet()
        setupIdSet(season, seasonNumber, IdType.CHAMPION, championIds, idSetsByType)

        val itemIds = units.flatMap { it.itemNames }.toSet()
        setupIdSet(season, seasonNumber, IdType.ITEM, itemIds, idSetsByType)

        val augments = decks.flatMap { it.augments }.toSet()
        setupIdSet(season, seasonNumber, IdType.AUGMENT, augments, idSetsByType)

        val synergies = decks.flatMap { it.traits }.map { it.name }.toSet()
        setupIdSet(season, seasonNumber, IdType.SYNERGY, synergies, idSetsByType)

        idSetRepository.saveAll(idSetsByType.values)
    }

    private fun setupIdSet(
            season: String,
            seasonNumber: Int,
            type: IdType,
            ids: Set<String>,
            idSetsByType: MutableMap<IdType, IdSet>
    ) {
        idSetsByType[type] = idSetsByType[type]
                ?.let {
                    it.ids = it.ids.union(ids)
                    it
                } ?: IdSet.of(season, seasonNumber, type, ids)
    }
}