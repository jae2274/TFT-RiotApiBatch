package com.tft.apibatch.domain.service

import com.tft.apibatch.domain.entity.Match
import com.tft.apibatch.domain.entity.Summoner
import com.tft.apibatch.domain.repository.MatchRepository
import com.tft.apibatch.domain.repository.SummonerRepository
import org.springframework.stereotype.Service

data class ExistedSummonersDTO(
    val newSummonerIds: List<String>,
    val existedSummoners: List<Summoner>,
)

@Service
class SummonerService(
    private val summonerRepository: SummonerRepository,
) {
    fun getExistedSummoners(summonerIds: Iterable<String>): ExistedSummonersDTO {
        val summoners = summonerRepository.findAllById(summonerIds)

        return ExistedSummonersDTO(
            newSummonerIds = summonerIds - summoners.map { it.summonerId }.toSet(),
            existedSummoners = summoners
        )
    }

    fun saveSummoner(summonerId: String, puuid: String): Summoner =
        summonerRepository.save(Summoner(summonerId = summonerId, puuid = puuid, System.currentTimeMillis()))

}