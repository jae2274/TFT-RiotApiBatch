package com.tft.apibatch.repository

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun testRepo(){
        val users = userRepository.findAllByPuuidIsNotNullAndIsProcessedFalse()

        Assertions.assertThat(users).isNotEmpty
        users.forEach { Assertions.assertThat(it.isProcessed).isFalse() }
    }
}