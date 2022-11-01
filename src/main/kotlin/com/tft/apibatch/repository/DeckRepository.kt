package com.tft.apibatch.repository

import com.tft.apibatch.entry.Deck
import com.tft.apibatch.entry.Match
import org.springframework.data.mongodb.repository.MongoRepository

interface DeckRepository : MongoRepository<Deck, String>