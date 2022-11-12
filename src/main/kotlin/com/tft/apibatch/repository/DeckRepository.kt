package com.tft.apibatch.repository

import com.tft.apibatch.entry.Deck
import org.springframework.data.mongodb.repository.MongoRepository

interface DeckRepository : MongoRepository<Deck, String>//, QuerydslPredicateExecutor<Deck>