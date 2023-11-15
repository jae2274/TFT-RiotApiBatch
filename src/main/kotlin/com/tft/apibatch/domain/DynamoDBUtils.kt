package com.tft.apibatch.domain

import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttribute
import kotlin.reflect.KMutableProperty1

fun <T, R> StaticAttribute.Builder<T, R>.attribute(kProperty1: KMutableProperty1<T, R>): StaticAttribute.Builder<T, R> {
    return this.name(kProperty1.name).getter(kProperty1.getter).setter(kProperty1.setter)
}