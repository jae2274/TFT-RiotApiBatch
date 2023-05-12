package com.tft.apibatch.service

import com.tft.apibatch.api.dto.MatchDTO
import com.tft.apibatch.entry.*
import com.tft.apibatch.repository.DeckRepository
import com.tft.apibatch.repository.IdSetRepository
import com.tft.apibatch.repository.TFTStatsRepository
import com.tft.apibatch.repository.WinnerDeckRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DataService(
    private val deckRepository: DeckRepository,
    private val winnerDeckRepository: WinnerDeckRepository,
    private val idSetRepository: IdSetRepository,
    private val tftStatsRepository: TFTStatsRepository,
) {

    fun filterIfExisted(matchIds: List<String>): List<String> {
        return winnerDeckRepository.findAllByMatchId(matchIds)
            .map { it.match_id }
            .toSet()
            .let { existedIds ->
                matchIds.filterNot { existedIds.contains(it) }
            }
    }

    @Transactional//mongoDB standalone에서는 트랜잭션은 작동하지 않는다
    fun saveData(matchDTO: MatchDTO) {

        val count = matchDTO.metadata.match_id
            .let { filterIfExisted(listOf(it)).count() }

        if (count <= 0) {
            return
        }

        val decks = Deck.listOf(matchDTO)

        saveDecks(decks)
        saveIdSets(decks)
        saveStats(decks)
    }

    private fun saveDecks(decks: List<Deck>) {
        deckRepository.saveAll(decks)
        decks.minByOrNull { it.placement }!!
            .apply { winnerDeckRepository.save(WinnerDeck.of(this)) }
    }

    private fun saveIdSets(decks: List<Deck>) {
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

    private fun saveStats(decks: List<Deck>) {
        val info = decks.first().info
        val tftStats = tftStatsRepository.findByGameVersion(info.game_version)
            ?: TftStats(
                gameVersion = info.game_version,
                season = info.tft_set_core_name,
                seasonNumber = info.tft_set_number,
            )

        for (deck in decks) {
            for (augment in deck.augments) {
                val augmentStats = tftStats.augments.getOrPut(augment) { TftStats.Stats() }
                augmentStats.totalCount += 1
                augmentStats.totalPlacement += deck.placement
            }

            for (trait in deck.traits) {
                val synergyStats = tftStats.synergies.getOrPut(trait.name) { TftStats.SynergyStats() }

                if (trait.tier_current != 0) {
                    synergyStats.totalCount += 1
                    synergyStats.totalPlacement += deck.placement
                }

                val synergyTierStats = synergyStats.tiers.getOrPut(trait.tier_current) { TftStats.Stats() }
                synergyTierStats.totalCount += 1
                synergyTierStats.totalPlacement += deck.placement
            }

            for (unit in deck.units) {
                val championStats = tftStats.champions.getOrPut(unit.character_id) { TftStats.ChampionStats() }
                championStats.totalCount += 1
                championStats.totalPlacement += deck.placement

                val championTierStats = championStats.tiers.getOrPut(unit.tier) { TftStats.Stats() }
                championTierStats.totalCount += 1
                championTierStats.totalPlacement += deck.placement

                for (itemName in unit.itemNames) {
                    val championItemStats = championStats.items.getOrPut(itemName) { TftStats.Stats() }
                    championItemStats.totalCount += 1
                    championItemStats.totalPlacement += deck.placement

                    val itemStats = tftStats.items.getOrPut(itemName) { TftStats.ItemStats() }
                    itemStats.totalCount += 1
                    itemStats.totalPlacement += deck.placement
                    val itemChampionStats = itemStats.champions.getOrPut(unit.character_id) { TftStats.Stats() }
                    itemChampionStats.totalCount += 1
                    itemChampionStats.totalPlacement += deck.placement
                }
            }
        }

        tftStatsRepository.save(tftStats)
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