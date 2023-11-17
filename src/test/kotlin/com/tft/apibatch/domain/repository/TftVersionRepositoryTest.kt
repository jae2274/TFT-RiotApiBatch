package com.tft.apibatch.domain.repository

import com.tft.apibatch.DynamoDBTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDateTime

@SpringBootTest
@ActiveProfiles("local")
class TftVersionRepositoryTest : DynamoDBTest() {

    @Autowired
    private lateinit var versionRepository: TftVersionRepository

    @Test
    fun whenNothingSaved() {

        // when
        val latestVersion = versionRepository.getLatestVersion()

        // then
        Assertions.assertThat(latestVersion).isNull()
    }

    @Test
    fun whenSaveOne() {
        // given
        val version = "Version 13.22.541.9804 (Nov 08 2023/01:52:34) [PUBLIC] "
        versionRepository.save(version)

        // when
        val latestVersion = versionRepository.getLatestVersion()

        // then
        Assertions.assertThat(latestVersion).isNotNull
        checkNotNull(latestVersion)
        Assertions.assertThat(latestVersion.version).isEqualTo(version)
        Assertions.assertThat(latestVersion.versionUpdatedAt).isEqualTo(LocalDateTime.of(2023, 11, 8, 1, 52, 34))
    }

    @Test
    fun whenSaveSeveral() {
        // given
        val latestVersion = "Version 13.22.541.9804 (Nov 08 2023/01:52:34) [PUBLIC] "
        val versions = listOf(
            "Version 13.22.541.9804 (Nov 07 2023/01:52:34) [PUBLIC] ",
            "Version 13.22.541.9804 (Nov 04 2023/01:52:34) [PUBLIC] ",
            "Version 13.22.541.9804 (Nov 05 2023/01:52:34) [PUBLIC] ",
            latestVersion,
            "Version 13.22.541.9804 (Nov 06 2023/01:52:34) [PUBLIC] ",
        )

        versions.forEach { versionRepository.save(it) }

        // when
        val actualLatestVersion = versionRepository.getLatestVersion()

        // then
        Assertions.assertThat(actualLatestVersion).isNotNull
        checkNotNull(actualLatestVersion)
        Assertions.assertThat(actualLatestVersion.version).isEqualTo(latestVersion)
        Assertions.assertThat(actualLatestVersion.versionUpdatedAt).isEqualTo(LocalDateTime.of(2023, 11, 8, 1, 52, 34))
    }
}