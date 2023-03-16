package com.tft.apibatch

import com.tft.apibatch.batch.DataCollector
import kotlinx.coroutines.runBlocking
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@EnableBatchProcessing
@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class TftRiotApiBatchApplication
(
        val dataCollector: DataCollector
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        runBlocking {
            while (true) {
                try {
                    dataCollector.collect()
                } catch (e: Exception) {
                    e.printStackTrace()
                    Thread.sleep(10000)
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<TftRiotApiBatchApplication>(*args)
}

