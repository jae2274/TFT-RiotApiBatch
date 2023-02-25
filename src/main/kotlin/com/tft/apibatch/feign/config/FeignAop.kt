package com.tft.apibatch.feign.config

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


@Aspect
@Component
class FeignAop(
        @Value("\${break-time}")
        val breakTime: Long
) {
    private val log = LoggerFactory.getLogger(javaClass)


    @Around("execution(* com.tft.apibatch.feign.*ApiClient.*(..))")
    @Throws(Throwable::class)
    fun logExecutionTime(joinPoint: ProceedingJoinPoint): Any? {
        return try {
            Thread.sleep(breakTime)
            joinPoint.proceed()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}