package com.tft.apibatch.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "idSet")
data class IdSet(
    @Id
    val _id: String? = null,
    val season: String,
    val seasonNumber: Int,
    val type: IdType,
    var ids: Set<String>,
) {
    companion object {
        fun of(season: String, seasonNumber: Int, type: IdType, ids: Set<String>): IdSet {
            return IdSet(
                season = season,
                seasonNumber = seasonNumber,
                type = type,
                ids = ids,
            )
        }


        fun listOf(decks: Collection<Deck>): List<IdSet> =
            decks.groupBy { it.info.tft_set_core_name to it.info.tft_set_number }
                .flatMap { listOf(it.key, it.value) }


        private fun listOf(seasonPair: Pair<String, Int>, decks: Collection<Deck>): List<IdSet> {
            val (season, seasonNumber) = seasonPair

            return listOf(
                listOf(season, seasonNumber, IdType.CHAMPION, decks),
                listOf(season, seasonNumber, IdType.ITEM, decks),
                listOf(season, seasonNumber, IdType.AUGMENT, decks),
                listOf(season, seasonNumber, IdType.SYNERGY, decks),
            )
        }

        private fun listOf(season: String, seasonNumber: Int, idType: IdType, decks: Collection<Deck>): IdSet {
            decks.checkValidSeason(season, seasonNumber)

            val idSet = when (idType) {
                IdType.CHAMPION -> decks.flatMap { it.units }.map { it.character_id }
                IdType.ITEM -> decks.flatMap { it.units }.flatMap { it.itemNames }
                IdType.AUGMENT -> decks.flatMap { it.augments }
                IdType.SYNERGY -> decks.flatMap { it.traits }.map { it.name }
            }.toSet()

            return IdSet(
                season = season,
                seasonNumber = seasonNumber,
                type = idType,
                ids = idSet
            )
        }

    }

    fun union(anotherIdSet: IdSet): IdSet {
        checkSameSeasonAndType(anotherIdSet)

        return this.copy(
            ids = this.ids.union(anotherIdSet.ids)
        )
    }

    private fun checkSameSeasonAndType(anotherIdSet: IdSet) {
        check(this.season == anotherIdSet.season) { "different season. this:${this.season}, another:${anotherIdSet.season}" }
        check(this.seasonNumber == anotherIdSet.seasonNumber) { "different seasonNumber. this:${this.seasonNumber}, another:${anotherIdSet.seasonNumber}" }
        check(this.type == anotherIdSet.type) { "different type. this:${this.type}, another:${anotherIdSet.type}" }
    }
}