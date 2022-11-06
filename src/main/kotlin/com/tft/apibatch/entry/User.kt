package com.tft.apibatch.entry


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


//@QueryEntity
@Document(collection = "user")
data class User
    (
    @Id
    val summonerId: String,
    var puuid: String? = null,
    var isProcessed: Boolean = false,
): BaseEntity()
