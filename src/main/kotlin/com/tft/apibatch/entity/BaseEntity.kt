package com.tft.apibatch.entity

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime


abstract class BaseEntity {
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set
}