package com.tft.apibatch.repository

import com.tft.apibatch.entry.User
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String>, QuerydslPredicateExecutor<User> {
    fun findAllByPuuidIsNull(pageable: Pageable): List<User>
    fun findAllByPuuidIsNotNullAndIsProcessedFalse(pageable: Pageable): List<User>
    fun findAllBySummonerIdInAndPuuidIsNotNull(summonerId: List<String>): List<User>
}