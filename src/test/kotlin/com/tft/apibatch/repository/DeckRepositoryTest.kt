package com.tft.apibatch.repository

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DeckRepositoryTest {
    @Autowired
    private lateinit var deckRepository: DeckRepository

    @Test
    fun testQuerydsl() {

        val page = deckRepository.findAllByCharacterId("TFT7_DragonGreen")

        for (deck in page.content.filterNotNull()) {
            println(deck)
        }
    }
}