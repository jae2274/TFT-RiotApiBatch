package com.tft.apibatch.mapstructure


import com.tft.apibatch.entry.Deck
import com.tft.apibatch.entry.Match
import com.tft.apibatch.feign.dto.MatchDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers


@Mapper
interface DeckMapper {
    fun participantToDeck(entity: Match.Participant, match_id: String): Deck // 3
    companion object {
        val INSTANCE: DeckMapper = Mappers.getMapper(DeckMapper::class.java) // 2
    }
}