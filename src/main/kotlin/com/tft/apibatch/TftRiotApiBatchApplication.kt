package com.tft.apibatch

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@EnableBatchProcessing
@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class TftRiotApiBatchApplication

fun main(args: Array<String>) {
    runApplication<TftRiotApiBatchApplication>(*args)
}
