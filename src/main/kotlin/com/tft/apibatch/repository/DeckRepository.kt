package com.tft.apibatch.repository

import com.tft.apibatch.entity.Deck
import org.springframework.data.mongodb.repository.MongoRepository

interface DeckRepository : MongoRepository<Deck, String>