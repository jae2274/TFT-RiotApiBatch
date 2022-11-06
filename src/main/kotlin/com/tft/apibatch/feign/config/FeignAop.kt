package com.tft.apibatch.feign.config

import lombok.extern.slf4j.Slf4j
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component



@Aspect
@Component
class FeignAop {
    private val log = LoggerFactory.getLogger(javaClass)

    @Value("\${break-time}")
    val breakTime: Long? = null


    @Around("execution(* com.tft.apibatch.feign.*ApiClient.*(..))")
    @Throws(Throwable::class)
    fun logExecutionTime(joinPoint: ProceedingJoinPoint): Any? {

        var proceed = joinPoint.proceed()
        Thread.sleep(breakTime!!)

        return proceed
    }
}