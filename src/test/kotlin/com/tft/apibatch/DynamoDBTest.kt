package com.tft.apibatch

import com.tft.apibatch.domain.entity.Match
import com.tft.apibatch.domain.repository.MatchRepository
import com.tft.apibatch.domain.repository.SummonerRepository
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Primary
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI


open class DynamoDBTest {
//    @TestConfiguration
//    class DynamoDBTestConfig {
//        @Bean
//        fun dynamoDbEnhancedClient(): DynamoDbEnhancedClient = DynamoDbEnhancedClient.builder()
//            .dynamoDbClient(
//                DynamoDbClient.builder()
//                    .endpointOverride(URI("http://localhost:8000"))
//                    .build()
//            )
//            .build()
//    }
//
//    @Autowired
//    private lateinit var matchRepository: MatchRepository
//
//    @Autowired
//    private lateinit var summonerRepository: SummonerRepository
//
//    @Autowired
//    private lateinit var enhancedClient: DynamoDbEnhancedClient
//
//    @BeforeEach
//    fun beforeEach() {
//        matchRepository.table = enhancedClient.table(Match.TABLE_NAME, TableSchema.fromBean(Match::class.java))
//    }
}