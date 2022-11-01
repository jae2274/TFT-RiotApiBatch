package com.tft.apibatch.repository

import com.tft.apibatch.entry.Match
import com.tft.apibatch.entry.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String>{
    fun findAllByPuuidIsNull(): List<User>
    fun findAllByPuuidIsNotNullAndIsProcessedFalse(): List<User>
}