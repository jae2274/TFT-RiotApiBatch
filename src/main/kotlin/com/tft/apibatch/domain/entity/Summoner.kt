package com.tft.apibatch.domain.entity

import com.tft.apibatch.domain.attribute
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1


@DynamoDbBean
data class Summoner(
    @get:DynamoDbPartitionKey
    var summonerId: String,
    @get:DynamoDbAttribute("puuid")
    var puuid: String,
    @get:DynamoDbAttribute("createdAt")
    var createdAt: Long,
) : DynamoDBEntity {
    companion object {
        val TABLE_NAME: String = "Summoner"
    }
}




