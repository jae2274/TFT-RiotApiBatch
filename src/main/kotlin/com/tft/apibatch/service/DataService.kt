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

        val characterIds = units.map { it.character_id }.toSet()
        saveSet(season, seasonNumber, IdType.CHAMPION, characterIds)

        val itemIds = units.flatMap { it.itemNames }.toSet()
        saveSet(season, seasonNumber, IdType.ITEM, itemIds)

        val augments = decks.flatMap { it.augments }.toSet()
        saveSet(season, seasonNumber, IdType.AUGMENT, augments)

        val synergies = decks.flatMap { it.traits }.map { it.name }.toSet()
        saveSet(season, seasonNumber, IdType.SYNERGY, synergies)
    }

    private fun saveSet(season: String, seasonNumber: Int, type: IdType, ids: Set<String>) {
        val newCharacterSet = idSetRepository.findBySeasonAndType(season, type)
                ?.let {
                    it.ids = it.ids.union(ids)
                    it
                } ?: IdSet.of(season, seasonNumber, type, ids)
        idSetRepository.save(newCharacterSet)
    }
}