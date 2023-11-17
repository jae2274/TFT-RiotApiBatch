package com.tft.apibatch.domain.repository

import com.tft.apibatch.domain.entity.TftVersion
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest

@Repository
class TftVersionRepository(
    val enhancedClient: DynamoDbEnhancedClient
) {

    lateinit var table: DynamoDbTable<TftVersion>

    init {
        enhancedClient.table(TftVersion.TABLE_NAME, TableSchema.fromBean(TftVersion::class.java))
            .let { table = it }
    }


    fun getLatestVersion(): TftVersion? {
        return table.query(
            QueryEnhancedRequest.builder()
                .queryConditional(
                    QueryConditional.keyEqualTo(
                        Key.builder().partitionValue(TftVersion.PARTITION_VALUE).build()
                    )
                )
                .scanIndexForward(false)
                .limit(1)
                .build()
        ).items().firstOrNull()
    }

    fun save(version: String) {
        val version = TftVersion.of(version)
        table.putItem(version)
    }
}