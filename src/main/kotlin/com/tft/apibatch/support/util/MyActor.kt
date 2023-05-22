package com.tft.apibatch.support.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ClosedSendChannelException
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.launch


// 메시지 형태를 Generic으로 정의합니다.
sealed class Message<T, R> {
    data class Process<T, R>(val message: T, val responseChannel: SendChannel<Result<R>>) : Message<T, R>()
    class Stop<T, R>(val responseChannel: SendChannel<Boolean>) : Message<T, R>()
}

open class MyActor<T, R>(
        private val processMessage: suspend (T) -> R, // 처리할 메시지를 인자로 받고 처리 결과를 반환하는 함수
) : CoroutineScope by CoroutineScope(Dispatchers.Default) {

    private val channel = Channel<Message<T, R>>(Channel.UNLIMITED)

    init {
        launch {
            for (message in channel) {
                when (message) {
                    is Message.Process -> {
                        try {
                            val response = processMessage(message.message)

                            message.responseChannel.send(
                                    Result.success(response)
                            )
                        } catch (e: Exception) {
                            message.responseChannel.send(Result.failure(e))
                        }
                    }

                    is Message.Stop -> {
                        message.responseChannel.send(
                                channel.close()
                        )

                        break
                    }
                }
            }
        }
    }

    fun stop(): ReceiveChannel<Boolean> {
        val responseChannel = Channel<Boolean>()

        launch {
            channel.send(Message.Stop(responseChannel))
        }

        return responseChannel
    }

    fun process(message: T): ReceiveChannel<Result<R>> {
        val responseChannel = Channel<Result<R>>(1)
        launch {
            val process = Message.Process(message, responseChannel)
            try {
                channel.send(process)
            } catch (e: ClosedSendChannelException) {
                responseChannel.send(Result.failure(e))
            }

        }

        return responseChannel
    }
}