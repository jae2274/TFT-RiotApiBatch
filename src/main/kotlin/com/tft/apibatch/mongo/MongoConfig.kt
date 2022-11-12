package com.tft.apibatch.mongo;

import com.mongodb.*;
import com.mongodb.connection.ConnectionPoolSettings.Builder;

import java.util.concurrent.TimeUnit;

//@Configuration
public interface MongoConfig {

    default MongoClientSettings mongoClientSettings(String uri, Block<Builder> poolSettings) {

        ConnectionString connectionString = new ConnectionString(uri);

        return MongoClientSettings.builder()
                .retryReads(false)
                .retryWrites(false)
                .writeConcern(WriteConcern.ACKNOWLEDGED)
                .readPreference(ReadPreference.secondaryPreferred())
                .applyConnectionString(connectionString)
                .applyToConnectionPoolSettings(poolSettings)
                .applyToSocketSettings(x -> {
                    x.connectTimeout(3, TimeUnit.SECONDS);
                    x.readTimeout(2, TimeUnit.SECONDS);
                })
                .build();
    }

    default MongoClientSettings mongoClientSettings(String uri, String userName, String dbname, String password, Block<Builder> poolSettings) {

        ConnectionString connectionString = new ConnectionString(uri);

        return MongoClientSettings.builder()
                .credential(MongoCredential.createCredential(userName, dbname, password.toCharArray()))
                .retryReads(false)
                .retryWrites(false)
                .writeConcern(WriteConcern.ACKNOWLEDGED)
                .readPreference(ReadPreference.secondaryPreferred())
                .applyConnectionString(connectionString)
                .applyToConnectionPoolSettings(poolSettings)
                .applyToSocketSettings(x -> {
                    x.connectTimeout(3, TimeUnit.SECONDS);
                    x.readTimeout(2, TimeUnit.SECONDS);
                })
                .build();
    }

    default Block<Builder> generalPoolSettings() {
        return x -> {
            x.maxSize(50);
            x.maxWaitTime(3, TimeUnit.SECONDS);
        };
    }

}
