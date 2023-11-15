package com.tft.apibatch.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.awscore.client.builder.AwsClientBuilder
import software.amazon.awssdk.endpoints.EndpointProvider
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.endpoints.internal.Value.Endpoint
import java.net.URI

@Configuration
class DynamoDBConfig(
    @Value("\${aws.dynamodb.endpoint}")
    private val endpoint: String?
) {

    @Bean
    fun dynamoDbEnhancedClient(): DynamoDbEnhancedClient = DynamoDbEnhancedClient.create()
}