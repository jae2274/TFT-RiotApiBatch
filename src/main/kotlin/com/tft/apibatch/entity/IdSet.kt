package com.tft.apibatch.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "idSet")
data class IdSet(
    @Id
    val _id: String? = null,
    val season: String,
    val seasonNumber: Int,
    val type: IdType,
    var ids: Set<String>,
) {
    companion object


}