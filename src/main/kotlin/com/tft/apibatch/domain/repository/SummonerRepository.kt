package com.tft.apibatch.domain.repository

import com.tft.apibatch.domain.entity.Summoner
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.model.*
import kotlin.String


@Repository
class SummonerRepository(
    private val enhancedClient: DynamoDbEnhancedClient,
) : DynamoDbRepository<Summoner>(enhancedClient, Summoner.TABLE_NAME, Summoner::class.java)
//{
//
//    lateinit var table: DynamoDbTable<Summoner>
//
//    init {
//        enhancedClient.table(Summoner.TABLE_NAME, TableSchema.fromBean(Summoner::class.java))
//            .let { table = it }
//    }
//
//
//    fun save(summoner: Summoner): Summoner {
//        table.putItem(summoner)
//        return summoner
//    }
//
//    fun findAllById(summonerIds: Iterable<String>): List<Summoner> {
//        val summonerBatch: ReadBatch = ReadBatch.builder(Summoner::class.java)
//            .mappedTableResource(table) // 1a. Specify the primary key values for the item.
//            .let { readBatch ->
//                val keys = summonerIds.map { Key.builder().partitionValue(it).build() }
//                val builder = keys.fold(readBatch) { readBatch, key -> readBatch.addGetItem(key) }
//                builder
//            }
//            .build()
//
//        // 3. Add ReadBatch objects to the request.
//        val resultPages = enhancedClient.batchGetItem { b: BatchGetItemEnhancedRequest.Builder ->
//            b.readBatches(
//                summonerBatch
//            )
//        }
//
//        // 4. Retrieve the successfully requested items from each table.
//        return resultPages.resultsForTable(table).toList()
//    }
//}