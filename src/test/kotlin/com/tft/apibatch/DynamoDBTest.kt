package com.tft.apibatch

import com.tft.apibatch.domain.repository.MatchRepository
import com.tft.apibatch.domain.repository.SummonerRepository
import kotlinx.coroutines.*
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model.DescribeTableRequest
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException
import software.amazon.awssdk.services.dynamodb.waiters.DynamoDbWaiter
import java.net.URI


open class DynamoDBTest {

    @Autowired
    private lateinit var matchRepository: MatchRepository

    @Autowired
    private lateinit var summonerRepository: SummonerRepository

    @Autowired
    private lateinit var dynamoDbClient: DynamoDbClient

    @BeforeEach
    fun beforeEach() = runBlocking {
        CoroutineScope(Dispatchers.IO).launch {
            val promise1 = async { matchRepository.table.truncateTable(dynamoDbClient) }
            val promise2 = async { summonerRepository.table.truncateTable(dynamoDbClient) }

            promise1.await()
            promise2.await()
        }.join()
    }
}

private fun DynamoDbTable<*>.truncateTable(dynamoDbClient: DynamoDbClient): Unit {
    val tableName = this.tableName()
    try {
        this.deleteTable()
    } catch (e: ResourceNotFoundException) {
        println("Table $tableName does not exist")
    }
    this.createTable()


    DynamoDbWaiter.builder().client(dynamoDbClient).build()
        .use { waiter ->  // DynamoDbWaiter is Autocloseable
            val response = waiter
                .waitUntilTableExists { builder: DescribeTableRequest.Builder ->
                    builder.tableName(tableName).build()
                }
                .matched()

            val tableDescription =
                response.response().orElseThrow {
                    RuntimeException(
                        "$tableName table was not created."
                    )
                }
            // The actual error can be inspected in response.exception()
            println("$tableName table was created.")
        }
}