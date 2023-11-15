package com.tft.apibatch

import com.tft.apibatch.app.AppService
import com.tft.apibatch.app.DataFlowMaker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class TftRiotApiBatchApplication(
    @Autowired
    private val flowMaker: DataFlowMaker
) : CommandLineRunner {

    override fun run(vararg args: String?) = runBlocking {
        CoroutineScope(Dispatchers.IO).launch {
            flowMaker.createFlow()
                .collect { println(it) }
        }.join()
    }
}

fun main(args: Array<String>) {
    runApplication<TftRiotApiBatchApplication>(*args).close()
}

