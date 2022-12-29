package com.tft.apibatch.repository

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest

@SpringBootTest
class RepositoryTest {
    @Autowired
    private lateinit var deckRepository: DeckRepository

    @Autowired
    private lateinit var matchRepository: MatchRepository

    @Test
    @Disabled
    fun test1() {
        val list = matchRepository.findForMappingParticipants(40)


    }

    @Test
    fun test2() {
        var list = matchRepository.findForExtractingDecks(PageRequest.of(0, 10))
        for (match in list) {
            println(match.match_id)
        }
        println("------------------------------")
        list = matchRepository.findForExtractingDecks(PageRequest.of(1, 10))
        for (match in list) {
            println(match.match_id)
        }
    }
}