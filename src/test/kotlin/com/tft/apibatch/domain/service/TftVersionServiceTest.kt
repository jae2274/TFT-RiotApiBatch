package com.tft.apibatch.domain.service

import com.tft.apibatch.DynamoDBTest
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("local")
class TftVersionServiceTest : DynamoDBTest() {

    @Autowired
    private lateinit var versionService: TftVersionService

    val targetVersion: String = "Version 13.22.541.9804 (Nov 08 2023/01:52:34) [PUBLIC] "
    val oldVersion: String = "Version 13.22.541.9804 (Nov 08 2023/01:52:33) [PUBLIC] "
    val newVersion: String = "Version 13.22.541.9804 (Nov 08 2023/01:52:35) [PUBLIC] "

    @Nested
    inner class TestUpdateVersion {
        @Test
        fun whenFirstVersion() = runTest {

            // when
            val isUpdated = versionService.updateVersionIfMoreLatest(targetVersion)

            // then
            Assertions.assertThat(isUpdated).isTrue()
        }

        @Test
        fun whenVersionAlreadyUpdated() = runTest {
            // given
            versionService.updateVersionIfMoreLatest(targetVersion)

            // when
            val isUpdated = versionService.updateVersionIfMoreLatest(targetVersion)

            // then
            Assertions.assertThat(isUpdated).isFalse()
        }

        @Test
        fun whenVersionNotLatest() = runTest {
            // given
            versionService.updateVersionIfMoreLatest(targetVersion)

            val isUpdated = versionService.updateVersionIfMoreLatest(oldVersion)

            // then
            Assertions.assertThat(isUpdated).isFalse()
        }

        @Test
        fun whenVersionLatest() = runTest {
            // given
            versionService.updateVersionIfMoreLatest(targetVersion)

            // when
            val isUpdated = versionService.updateVersionIfMoreLatest(newVersion)

            // then
            Assertions.assertThat(isUpdated).isTrue()
        }
    }

    @Nested
    inner class testIsLatest {
        @Test
        fun whenFirstVersion() = runTest {
            // when
            val isLatest = versionService.isLatest(targetVersion)

            // then
            Assertions.assertThat(isLatest).isTrue()
        }

        @Test
        fun whenVersionAlreadyUpdated() = runTest {
            // given
            versionService.updateVersionIfMoreLatest(targetVersion)

            // when
            val isLatest = versionService.isLatest(targetVersion)

            // then
            Assertions.assertThat(isLatest).isTrue()
        }

        @Test
        fun whenVersionNotLatest() = runTest {
            // given
            versionService.updateVersionIfMoreLatest(targetVersion)

            // when
            val isLatest = versionService.isLatest(oldVersion)

            // then
            Assertions.assertThat(isLatest).isFalse()
        }

        @Test
        fun whenVersionLatest() = runTest {
            // given
            versionService.updateVersionIfMoreLatest(targetVersion)

            // when
            val isLatest = versionService.isLatest(newVersion)

            // then
            Assertions.assertThat(isLatest).isTrue()
        }
    }
}