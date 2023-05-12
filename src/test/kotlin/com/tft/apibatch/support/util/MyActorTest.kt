package com.tft.apibatch.support.util

import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.*
import org.assertj.core.data.Percentage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MyActorTest {

    companion object {
        val breakTime = 2000L
    }

    data class DivideMessage(
        val dividend: Long,
        val divisor: Long,
    )

    private val task = { message: DivideMessage ->
        Thread.sleep(breakTime)
        message.dividend / message.divisor
    }

    private val actor: MyActor<DivideMessage, Long> = MyActor(task)

    @Test
    @DisplayName("여러 쓰레드, 또는 코루틴에서 동시에 process를 호출하여도 하나의 코루틴 안에서 순차적으로 처리된다.")
    fun test() = runTest {

        val extectedResults = listOf(2L, 3L, 4L, 6L)
        val divideMessages = listOf(
            DivideMessage(12, 6),
            DivideMessage(12, 4),
            DivideMessage(12, 3),
            DivideMessage(12, 2),
        )


        withContext(Dispatchers.IO) {
            val defferedList = divideMessages.map { async { task(it) } }

            val start = System.currentTimeMillis()
            val results = defferedList.map { it.await() }
            val requiredTime = System.currentTimeMillis() - start

            assertThat(results).isEqualTo(extectedResults)
            assertThat(requiredTime).isCloseTo(breakTime, Percentage.withPercentage(10.toDouble()))
        }

        withContext(Dispatchers.IO) {
            val defferedList = divideMessages.map {
                async { actor.process(it).receive().getOrThrow() }
            }

            val start = System.currentTimeMillis()
            val results = defferedList.map { it.await() }
            val requiredTime = System.currentTimeMillis() - start

            assertThat(results).isEqualTo(extectedResults)
            assertThat(requiredTime).isCloseTo(4 * breakTime, Percentage.withPercentage(10.toDouble()))
        }
    }

    
    @Test
    @DisplayName("actor 내부에서 실행 중 예외가 발생한 경우")
    fun ifFailed() {
        val receiveChannel = actor.process(DivideMessage(5, 0))

        runBlocking {
            val result = receiveChannel.receive()
            assertThat(result.isFailure).isTrue

            try {
                result.getOrThrow()
            } catch (e: ArithmeticException) {
                assertThat(e.message).isEqualTo("/ by zero")
            }
        }
    }
}