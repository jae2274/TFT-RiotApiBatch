package com.tft.apibatch.repository

import com.tft.apibatch.entity.TftStats
import org.springframework.data.mongodb.repository.MongoRepository

interface TFTStatsRepository : MongoRepository<TftStats, String> {
    fun findByGameVersion(gameVersion: String): TftStats?
}