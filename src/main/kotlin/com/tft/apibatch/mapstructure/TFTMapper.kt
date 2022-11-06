package com.tft.apibatch.mapstructure

import com.tft.apibatch.entry.Deck
import com.tft.apibatch.entry.Match
import com.tft.apibatch.feign.dto.MatchDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper
interface TFTMapper {

    fun participantFromDTO(dto: MatchDTO.ParticipantDTO): Match.Participant // 3
    fun infoFromDTO(dto: MatchDTO.InfoDTO): Match.Info // 3
//    fun entryToDTO(entity: Match.Participant): MatchDTO.ParticipantDTO // 3

    @Mapping(target = "info", source = "info")
    fun participantToDeck(entity: Match.Participant, match_id: String, info : Match.Info): Deck // 3
    fun deckInfoFromParticipantInfo(info: Match.Info): Deck.Info
    companion object {
        val INSTANCE: TFTMapper = Mappers.getMapper(TFTMapper::class.java) // 2
    }
}