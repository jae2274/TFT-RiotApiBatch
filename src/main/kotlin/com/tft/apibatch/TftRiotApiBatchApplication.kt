package com.tft.apibatch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling


@SpringBootApplication
class TftRiotApiBatchApplication

fun main(args: Array<String>) {
    runApplication<TftRiotApiBatchApplication>(*args)
}

