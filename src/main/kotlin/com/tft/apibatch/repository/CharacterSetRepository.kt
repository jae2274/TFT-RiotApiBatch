package com.tft.apibatch.repository;

import com.tft.apibatch.entry.CharacterSet
import org.springframework.data.mongodb.repository.MongoRepository

interface CharacterSetRepository : MongoRepository<CharacterSet, String>