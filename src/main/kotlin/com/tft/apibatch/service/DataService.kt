package com.tft.apibatch.service

import com.tft.apibatch.entry.Deck
import com.tft.apibatch.entry.IdSet
import com.tft.apibatch.entry.IdType
import com.tft.apibatch.entry.Match
import com.tft.apibatch.feign.dto.MatchDTO
import com.tft.apibatch.repository.DeckRepository
import com.tft.apibatch.repository.IdSetRepository
import com.tft.apibatch.repository.MatchRepository
import org.springframework.stereotype.Service

@Service
class DataService(
        private val matchRepository: MatchRepository,
        private val deckRepository: DeckRepository,
        private val idSetRepository: IdSetRepository,
) {

    fun saveData(matchDTO: MatchDTO) {
        val decks = Deck.listOf(matchDTO)
        deckRepository.saveAll(decks)
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

    private fun setupIdSet(season: String, seasonNumber: Int, type: IdType, ids: Set<String>, idSetsByType: MutableMap<IdType, IdSet>) {
        idSetsByType[type] = idSetsByType[type]
                ?.let {
                    it.ids = it.ids.union(ids)
                    it
                } ?: IdSet.of(season, seasonNumber, type, ids)
    }
}