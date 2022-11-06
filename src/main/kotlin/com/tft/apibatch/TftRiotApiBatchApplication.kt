package com.tft.apibatch

import com.tft.apibatch.entry.User
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.mongodb.config.EnableMongoAuditing

@EnableFeignClients
@EnableMongoAuditing
@EnableBatchProcessing
@SpringBootApplication
class TftRiotApiBatchApplication

fun main(args: Array<String>) {
    runApplication<TftRiotApiBatchApplication>(*args)
}
