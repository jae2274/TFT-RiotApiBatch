package com.tft.apibatch.repository;

import com.tft.apibatch.entity.IdSet
import com.tft.apibatch.entity.IdType
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface IdSetRepository : MongoRepository<IdSet, String> {
    @Query("{'season': ?0, seasonNumber: ?1, type: ?2}")
    fun findBySeasonAndType(season: String, seasonNumber: Int, type: IdType): IdSet?
}