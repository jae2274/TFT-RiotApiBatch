package com.tft.apibatch.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class TFTMongoConfig implements MongoConfig {





    @Value("${mongodb.uri}")
    private String uri;


    @Value("${mongodb.dbname}")
    private String dbname;

    @Setter
    private String user;

    @Setter
    String password;


    @Bean("mongoClient")
    public MongoClient mongoClient() {
        return MongoClients.create(mongoClientSettings(uri, generalPoolSettings()));
    }

    @Bean("mongoTemplate")
    public MongoTemplate mongoTemplate(
            @Qualifier("mongoClient") MongoClient mongoClient
    ) {
        return new MongoTemplate(mongoClient, dbname);
    }
}
