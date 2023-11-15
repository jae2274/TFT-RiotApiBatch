package com.tft.apibatch.domain.repository

import com.tft.apibatch.domain.entity.Match
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.model.BatchGetItemEnhancedRequest
import software.amazon.awssdk.enhanced.dynamodb.model.ReadBatch

@Repository
class MatchRepository(
    enhancedClient: DynamoDbEnhancedClient
) : DynamoDbRepository<Match>(enhancedClient, Match.TABLE_NAME, Match::class.java)

//{
//
//    lateinit var table: DynamoDbTable<Match>
//
//    init {
//        enhancedClient.table(Match.TABLE_NAME, TableSchema.fromBean(Match::class.java))
//            .let { table = it }
//    }
//
//    fun save(matchId: Match): Match {
//        table.putItem(matchId)
//        return matchId
//    }
//
//    fun findAllById(matchIds: Iterable<String>): List<Match> {
//        val readBatch: ReadBatch = ReadBatch.builder(Match::class.java)
//            .mappedTableResource(table) // 1a. Specify the primary key values for the item.
//            .let { readBatch ->
//                val keys = matchIds.map { Key.builder().partitionValue(it).build() }
//                keys.forEach { readBatch.addGetItem(it) }
//                readBatch
//            }
//            .build()
//
//        // 3. Add ReadBatch objects to the request.
//        val resultPages = enhancedClient.batchGetItem { b: BatchGetItemEnhancedRequest.Builder ->
//            b.readBatches(
//                readBatch
//            )
//        }
//
//        // 4. Retrieve the successfully requested items from each table.
//        return resultPages.resultsForTable(table).toList()
//    }
//}