package com.tft.apibatch.repository

import com.tft.apibatch.entry.WinnerDeck
import org.springframework.data.mongodb.repository.MongoRepository

interface WinnerDeckRepository : MongoRepository<WinnerDeck, String>