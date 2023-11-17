package com.tft.apibatch.domain.entity

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import java.time.LocalDateTime

@DynamoDbBean
data class TftVersion(
    @get:DynamoDbPartitionKey
    var tftVersion: TftVersion,
    @get:DynamoDbAttribute("puuid")
    var versionUpdatedAt: Long,
    @get:DynamoDbAttribute("createdAt")
    var createdAt: Long,
)