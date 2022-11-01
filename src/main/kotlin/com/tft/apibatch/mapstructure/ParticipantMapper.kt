package com.tft.apibatch.mapstructure

import com.tft.apibatch.entry.Match
import com.tft.apibatch.feign.dto.MatchDTO
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface ParticipantMapper: BaseMapper<MatchDTO.ParticipantDTO, Match.Participant> {

//    fun dtoToEntry(dto: MatchDTO.ParticipantDTO): Match.Participant // 3
//    fun entryToDTO(entity: Match.Participant): MatchDTO.ParticipantDTO // 3
    companion object {
        val INSTANCE: ParticipantMapper = Mappers.getMapper(ParticipantMapper::class.java) // 2
    }
}