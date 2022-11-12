package com.tft.apibatch.mongo

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoAuditing
@EnableMongoRepositories(basePackages = ["com.tft.apibatch.repository"])
@EnableJpaRepositories(basePackages = [])
@Configuration
class TFTMongoConfig : MongoConfig {
    @Value("\${mongodb.uri}")
    private val uri: String? = null

    @Value("\${mongodb.dbname}")
    private val dbname: String? = null
    
    @Bean("mongoClient")
    fun mongoClient(): MongoClient {
        return MongoClients.create(mongoClientSettings(uri, generalPoolSettings()))
    }

    @Bean("mongoTemplate")
    fun mongoTemplate(
        @Qualifier("mongoClient") mongoClient: MongoClient?
    ): MongoTemplate {
        return MongoTemplate(mongoClient!!, dbname!!)
    }
}