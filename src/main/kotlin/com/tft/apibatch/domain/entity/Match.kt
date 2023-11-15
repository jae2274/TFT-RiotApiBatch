package com.tft.apibatch.domain.entity

import com.tft.apibatch.domain.attribute
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey


@DynamoDbBean
data class Match(
    @get:DynamoDbPartitionKey
    var matchId: String,
    @get:DynamoDbAttribute("createdAt")
    var createdAt: Long,
) : DynamoDBEntity {
    companion object {
        val TABLE_NAME: String = "Match"
    }
}