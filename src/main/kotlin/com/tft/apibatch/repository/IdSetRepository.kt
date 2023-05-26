package com.tft.apibatch.repository;

import com.tft.apibatch.entity.IdSet
import com.tft.apibatch.entity.IdType
import org.springframework.data.mongodb.repository.MongoRepository

interface IdSetRepository : MongoRepository<IdSet, String> {
    fun findBySeasonAndType(season: String, type: IdType): IdSet?
    fun findBySeason(season: String): List<IdSet>
}