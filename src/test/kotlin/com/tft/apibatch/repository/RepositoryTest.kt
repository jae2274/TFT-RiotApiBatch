package com.tft.apibatch.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RepositoryTest {
    @Autowired
    private lateinit var deckRepository: DeckRepository

    @Autowired
    private lateinit var matchRepository: MatchRepository

}