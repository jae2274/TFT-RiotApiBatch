package com.tft.apibatch.repository;

import com.tft.apibatch.entry.IdSet
import com.tft.apibatch.entry.IdType
import org.springframework.data.mongodb.repository.MongoRepository

interface IdSetRepository : MongoRepository<IdSet, String> {
    fun findBySeasonAndType(season: String, type: IdType): IdSet?
}