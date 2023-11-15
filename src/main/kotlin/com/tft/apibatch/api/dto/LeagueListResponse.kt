package com.tft.apibatch.api.dto


data class LeagueListResponse(
    val entries: List<LeagueItemResponse>,
    val tier: String,
) {
    data class LeagueItemResponse(
        val summonerId: String,
    )
}