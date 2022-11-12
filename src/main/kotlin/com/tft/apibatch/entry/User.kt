package com.tft.apibatch.entry


import com.querydsl.core.annotations.QueryEntity
import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Entity
import javax.persistence.Id


@Entity
@QueryEntity
@Document(collection = "user")
data class User
    (
    @Id
    var summonerId: String = "",
    var puuid: String? = null,
    var isProcessed: Boolean = false,
) : BaseEntity()
