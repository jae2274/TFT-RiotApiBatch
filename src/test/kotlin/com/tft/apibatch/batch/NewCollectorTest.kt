package com.tft.apibatch.batch

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class NewCollectorTest {
    @Autowired
    lateinit var newCollector: NewCollector

    @Test
    fun test() {
        newCollector.collectData(10000)
    }
}