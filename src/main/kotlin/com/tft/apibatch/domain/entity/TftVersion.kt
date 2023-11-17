package com.tft.apibatch.domain.entity

import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.LocalDateTimeAttributeConverter
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalField
import java.util.TimeZone

@DynamoDbBean
data class TftVersion(
    var version: String,

    @get:DynamoDbConvertedBy(LocalDateTimeAttributeConverter::class)
    @get:DynamoDbSortKey
    var versionUpdatedAt: LocalDateTime,

    @get:DynamoDbConvertedBy(LocalDateTimeAttributeConverter::class)
    @get:DynamoDbAttribute("createdAt")
    var createdAt: LocalDateTime,


    ) {
    @get:DynamoDbPartitionKey
    var partitionKey = PARTITION_VALUE

    companion object {
        const val PARTITION_VALUE = "only_one_key"
        const val TABLE_NAME = "tftVersion"
        private val formatter = DateTimeFormatter.ofPattern("MMM dd yyyy/HH:mm:ss")
        fun versionUpdatedAt(version: String): LocalDateTime {
            // DateTimeFormatter를 이용하여 문자열을 LocalDateTime 객체로 변환
            val startIndexOfDate = version.indexOf('(') + 1
            val endIndexOfDate = version.indexOf(')')
            val dateString = version.substring(startIndexOfDate, endIndexOfDate)

            return LocalDateTime.parse(dateString, formatter)
        }

        fun of(version: String): TftVersion {
            return TftVersion(
                version,
                versionUpdatedAt(version),
                LocalDateTime.now()
            )
        }
    }
}