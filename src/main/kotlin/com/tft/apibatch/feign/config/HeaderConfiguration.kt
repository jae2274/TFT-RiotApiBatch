package com.tft.apibatch.feign.config

import feign.RequestInterceptor
import feign.RequestTemplate
import feign.codec.Decoder
import feign.codec.Encoder
import feign.form.spring.SpringFormEncoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.cloud.openfeign.support.SpringEncoder
import org.springframework.context.annotation.Bean


//@Configuration
class HeaderConfiguration {



    private val messageConverters: ObjectFactory<HttpMessageConverters> =
        ObjectFactory<HttpMessageConverters> { HttpMessageConverters() }

    @Bean
    fun feignFormEncoder(): Encoder? {
        return SpringFormEncoder(SpringEncoder(messageConverters))
    }

    @Bean
    fun feignFormDecoder(): Decoder? {
        return SpringDecoder(messageConverters)
    }

//    @Bean
//    fun requestInterceptor(): RequestInterceptor {
//        return RequestInterceptor { requestTemplate: RequestTemplate ->
//            requestTemplate.header(
//
//            )
//        }
//    }
}