package com.tft.apibatch.repository

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RepositoryTest {
    @Autowired
    private lateinit var deckRepository: DeckRepository

    @Autowired
    private lateinit var matchRepository: MatchRepository

    @Test
    fun findAllByCharacterId() {

        val page = deckRepository.findAllByCharacterId("TFT7_DragonGreen")

        for (deck in page.content.filterNotNull()) {
            println(deck)
        }
    }

//    @Test
//    fun testQuerydsl() {
//
//        val mostRecentMatch = matchRepository.findTop1ByOrderByInfo_Game_datetimeDesc()
//
//        println(mostRecentMatch)
//    }
}