package com.tft.apibatch.batch

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("aws")
class NewCollectorTest {
    @Autowired
    lateinit var newCollector: NewCollector

    @Test
    fun test() {
        runBlocking {
            newCollector.collectData()
        }
    }
}