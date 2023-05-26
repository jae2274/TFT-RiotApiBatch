package com.tft.apibatch

import com.tft.apibatch.entity.WinnerDeck
import com.tft.apibatch.service.DataService
import com.tft.apibatch.support.util.SlackUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
class HealthCheckController(
    private val dataService: DataService,
    private val slackUtil: SlackUtil,
) {
    @RequestMapping
    fun healthCheck(): WinnerDeck {
        return dataService.findLastSavedDeck()
            .also {
                if (LocalDateTime.now() > it.createdAt.plusSeconds(1))
                    slackUtil.sendSlackMessage(NotCollectedStatusException(it.createdAt))
            }
    }
}


class NotCollectedStatusException(
    val lastCollectedDate: LocalDateTime
) : Exception("마지막으로 수집된 날짜: ${lastCollectedDate.format(dateTimeFormatter)}") {
    companion object {
        val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")
    }
}