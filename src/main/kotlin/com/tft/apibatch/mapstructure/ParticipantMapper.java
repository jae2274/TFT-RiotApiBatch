//package com.tft.apibatch.mapstructure;
//
//import com.tft.apibatch.entry.Match;
//import com.tft.apibatch.feign.dto.MatchDTO;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//
//@Mapper
//public interface ParticipantMapper {
//    ParticipantMapper INSTANCE = Mappers.getMapper( ParticipantMapper.class ); // 2
//
//    Match.Participant dtoToEntry(MatchDTO.ParticipantDTO dto); // 3
//
//    MatchDTO.ParticipantDTO entryToDTO(Match.Participant entry);
//}