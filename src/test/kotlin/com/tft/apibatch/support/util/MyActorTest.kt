package com.tft.apibatch.support.util

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ClosedSendChannelException
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.*
import org.assertj.core.data.Percentage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

data class DivideMessage(
    val dividend: Long,
    val divisor: Long,
)

suspend fun divideTask(message: DivideMessage): Long {
    delay(MyActorTest.breakTime)
    return message.dividend / message.divisor
}

class DivideActor : MyActor<DivideMessage, Long>() {
    override suspend fun processMessage(message: DivideMessage): Long = divideTask(message)

}

class MyActorTest {

    companion object {
        const val breakTime = 1000L

        val expectedResults = listOf(1L, 2L, 3L, 4L, 6L)
        val divideMessages = listOf(
            DivideMessage(12, 12),
            DivideMessage(12, 6),
            DivideMessage(12, 4),
            DivideMessage(12, 3),
            DivideMessage(12, 2),
        )
    }


    private val actor: DivideActor = DivideActor()


    @Test
    @DisplayName("MyActor를 사용한 순차 실행 테스트")//여러 쓰레드, 또는 코루틴에서 동시에 process를 호출하여도 하나의 코루틴 안에서 순차적으로 처리된다.
    fun runningConcurrentlyByMyActor() = runTest {
        //비교를 위한 코틀린 병렬 실행 테스트, 다른 의미는 없다.
        checkTime {
            runningConcurrently(divideMessages) { divideTask(it) }
        }
            .let { (requiredTime, results) ->
                assertAll(
                    { assertThat(results).isEqualTo(expectedResults) },
                    { assertThat(requiredTime).isCloseTo(breakTime, Percentage.withPercentage(10.0)) }
                )
            }

        //위의 테스트와 비교하여 소요되는 시간을 주시한다.
        checkTime {
            runningConcurrently(divideMessages) { actor.process(it).receive().getOrThrow() }
        }
            .let { (requiredTime, results) ->
                assertAll(
                    { assertThat(results).isEqualTo(expectedResults) },
                    {
                        assertThat(requiredTime).isCloseTo(
                            breakTime * expectedResults.size,
                            Percentage.withPercentage(10.0)
                        )
                    }
                )
            }
    }

    private suspend fun <T> checkTime(
        action: suspend () -> T?
    ): Pair<Long, T> {
        val start = System.currentTimeMillis()
        val result = action()
        val requiredTime = System.currentTimeMillis() - start

        println(requiredTime)
        return requiredTime to result!!
    }

    private suspend fun runningConcurrently(
        divideMessages: List<DivideMessage>,
        function: suspend (DivideMessage) -> Long
    ): List<Long> = withContext(Dispatchers.IO) {
        val defferedList = divideMessages.map { async { function(it) } }
        defferedList.map { it.await() }
    }


    @Test
    @DisplayName("MyActor 내부에서 실행 중 예외가 발생한 경우")
    fun ifFailed() = runTest {
        val receiveChannel = actor.process(DivideMessage(5, 0))

        val result = receiveChannel.receive()
        assertThat(result.isFailure).isTrue

        try {
            result.getOrThrow()
            fail("Expect ArithmeticException, but not caused")
        } catch (e: ArithmeticException) {
            assertThat(e.message).isEqualTo("/ by zero")
        }
    }

    @Test
    @DisplayName("MyActor stop 메서도 테스트")
    fun stop() = runTest {
        val divideMessage = DivideMessage(10, 2)

        assertThat(actor.process(divideMessage).receive().isSuccess).isTrue

        assertThat(actor.stop().receive()).isTrue

        val result = actor.process(DivideMessage(10, 2)).receive()
        assertThat(result.isFailure).isTrue

        try {
            result.getOrThrow()
            fail("Expect ClosedSendChannelException, but not caused")
        } catch (e: ClosedSendChannelException) {
            assertThat(e.message).isEqualTo("Channel was closed")
        }
    }
}