package com.tft.apibatch.support.util

import net.gpedro.integrations.slack.SlackApi
import net.gpedro.integrations.slack.SlackAttachment
import net.gpedro.integrations.slack.SlackMessage
import org.springframework.stereotype.Component
import java.util.*

@Component
class SlackUtil(
    private val slackApi: SlackApi,
) {
    fun sendSlackMessage(e: Throwable) {
        val slackAttachment = SlackAttachment()
        slackAttachment.setFallback("Error")
        slackAttachment.setColor("danger")
        slackAttachment.setTitle("Error Detect From tft-api-batch")
        slackAttachment.setText(e.stackTraceToString())
        slackAttachment.setColor("danger")

        val slackMessage = SlackMessage()
        slackMessage.setAttachments(Collections.singletonList(slackAttachment))
        slackMessage.setIcon(":ghost:")
        slackMessage.setText("Error Detect")

        slackApi.call(slackMessage)
    }
}