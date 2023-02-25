package com.tft.apibatch.entry

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime


abstract class BaseEntity {
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set
}