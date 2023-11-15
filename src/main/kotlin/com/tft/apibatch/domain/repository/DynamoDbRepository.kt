package com.tft.apibatch.domain.repository

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match
import com.tft.apibatch.domain.entity.DynamoDBEntity
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.model.BatchGetItemEnhancedRequest
import software.amazon.awssdk.enhanced.dynamodb.model.ReadBatch
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


abstract class DynamoDbRepository<T : DynamoDBEntity>(
    private val enhancedClient: DynamoDbEnhancedClient,
    private val tableName: String,
    private val entityClass: Class<T>
) {
    lateinit var table: DynamoDbTable<T>

    init {
        enhancedClient.table(tableName, TableSchema.fromBean(entityClass))
            .let { table = it }
    }

    fun save(entity: T): T {
        table.putItem(entity)
        return entity
    }

    fun findAllById(ids: Iterable<String>): List<T> {
        val readBatch: ReadBatch = ReadBatch.builder(entityClass)
            .mappedTableResource(table)
            .let { readBatch ->
                val keys = ids.map { Key.builder().partitionValue(it).build() }
                keys.forEach { readBatch.addGetItem(it) }
                readBatch
            }
            .build()

        val resultPages = enhancedClient.batchGetItem { b: BatchGetItemEnhancedRequest.Builder ->
            b.readBatches(readBatch)
        }

        return resultPages.resultsForTable(table).toList()
    }
}