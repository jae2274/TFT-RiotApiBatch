package com.tft.apibatch

import com.tft.apibatch.entry.Match
import com.tft.apibatch.entry.User
import com.tft.apibatch.feign.AsiaApiClient
import com.tft.apibatch.feign.KrApiClient
import com.tft.apibatch.feign.dto.LeagueListDTO
import com.tft.apibatch.feign.dto.MatchDTO
import com.tft.apibatch.feign.dto.SummonerDTO
import com.tft.apibatch.mapstructure.DeckMapper
import com.tft.apibatch.mapstructure.TFTMapper
import com.tft.apibatch.repository.DeckRepository
//import com.tft.apibatch.mapstructure.ParticipantMapper
import com.tft.apibatch.repository.MatchRepository
import com.tft.apibatch.repository.UserRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
class FeignTest {
    @Autowired
    lateinit var krApiClient : KrApiClient
    @Autowired
    lateinit var asiaApiClient: AsiaApiClient

    @Autowired
    lateinit var matchRepository: MatchRepository

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var deckRepository: DeckRepository

    @Value("\${api-token}")
    lateinit var apiToken : String

    @Test
    fun callChallengerLeagues(){
        //api 호출 후 summonerId db에 저장
        val leagueListDTO : LeagueListDTO? = krApiClient.callChallengerLeagues(apiToken)
        println(leagueListDTO)

        Assertions.assertThat(leagueListDTO).isNotNull

        userRepository.saveAll(
            leagueListDTO!!.entries
                .map { User(it.summonerId) }
        )

        //저장했던 summonerId 가져와서 puuid 수집
       val users = userRepository.findAllByPuuidIsNull(PageRequest.of(0,1))

        val summonerDTO :SummonerDTO = krApiClient.callSummoner(apiToken, users[0].summonerId)
        println(summonerDTO)

        Assertions.assertThat(summonerDTO).isNotNull

        users[0].puuid = summonerDTO.puuid

        userRepository.save(users[0])

        //puuid 가져와서 matchId 수집
        val user = userRepository.findByIdOrNull(users[0].summonerId)

        val callMatches : List<String>? = asiaApiClient.callMatches(apiToken, user!!.puuid!!, 0, 100);
        println(callMatches)

        Assertions.assertThat(callMatches).isNotNull.isNotEmpty

        matchRepository.saveAll(
            callMatches!!
                .map { Match(it) }
        )

        user.isProcessed = true
        userRepository.save(user);

        //수집된 matchId를 통해 실제 경기데이터 수집
        val matches = matchRepository.findAllByParticipantsIsNull(PageRequest.of(0,1))

        val matchDTO : MatchDTO = asiaApiClient.callMatch(apiToken, matches[0].match_id)
        println(matchDTO)

        matches[0].participants = matchDTO.info.participants
            .map { TFTMapper.INSTANCE.participantFromDTO(it) }


        matchRepository.save(
            matches[0]
        )

        Assertions.assertThat(matchDTO).isNotNull

        deckRepository.saveAll(
            matches[0].participants!!
                .map { TFTMapper.INSTANCE.participantToDeck(it, matches[0].match_id, matches[0].info!!) }
        )

        matches[0].isProcessed = true
        matchRepository.save(matches[0])
    }

}