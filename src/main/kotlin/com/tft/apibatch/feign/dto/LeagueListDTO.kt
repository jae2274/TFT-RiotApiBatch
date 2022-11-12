package com.tft.apibatch.feign.dto


data class LeagueListDTO(
    val leagueId: String?,
    val entries: List<LeagueItemDTO>,
    val tier: String?,
    val name: String?,
    val queue: String?,
) {

    data class LeagueItemDTO(
        val freshBlood: Boolean?,
        val wins: Int?,
        val summonerName: String?,
        val miniSeries: MiniSeriesDTO?,
        val inactive: Boolean?,
        val veteran: Boolean?,
        val hotStreak: Boolean?,
        val rank: String?,
        val leaguePoIntegers: Int?,
        val losses: Int?,
        val summonerId: String,
    )


    data class MiniSeriesDTO(
        val losses: Int?,
        val progress: String?,
        val target: Int?,
        val wins: Int?,
    )
}