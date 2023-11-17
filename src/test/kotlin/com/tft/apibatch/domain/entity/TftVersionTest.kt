package com.tft.apibatch.domain.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDateTime
import java.util.TimeZone

@SpringBootTest(classes = [])
@ActiveProfiles("local")
class TftVersionTest {
    @Test
    fun testExtractVersionDate() {
        assert(TimeZone.getDefault() == TimeZone.getTimeZone("UTC"))

        val versionUpdatedAt = TftVersion.versionUpdatedAt("Version 13.22.541.9804 (Nov 08 2023/01:52:34) [PUBLIC] ")

        Assertions.assertThat(versionUpdatedAt).isEqualTo(LocalDateTime.of(2023, 11, 8, 1, 52, 34))
    }
}