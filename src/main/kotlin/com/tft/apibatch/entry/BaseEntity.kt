package com.tft.apibatch.entry

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass


abstract class BaseEntity {
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set
}