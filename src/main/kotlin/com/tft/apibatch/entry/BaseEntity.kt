package com.tft.apibatch.entry

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime


abstract class BaseEntity {
    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now()
}