package com.tft.apibatch.domain.service

import com.tft.apibatch.domain.entity.TftVersion
import com.tft.apibatch.domain.repository.TftVersionRepository
import org.springframework.stereotype.Service

@Service
class TftVersionService(
    private val versionRepository: TftVersionRepository
) {
    fun updateVersionIfMoreLatest(version: String): Boolean {
        val latestVersion: TftVersion? = versionRepository.getLatestVersion()
        val versionUpdated = TftVersion.versionUpdatedAt(version)

        if (latestVersion == null || latestVersion.versionUpdatedAt < versionUpdated) {
            versionRepository.save(version)
            return true
        }

        return false
    }

    fun isLatest(version: String): Boolean {
        val latestVersion: TftVersion? = versionRepository.getLatestVersion()
        val versionUpdated = TftVersion.versionUpdatedAt(version)

        return latestVersion == null || latestVersion.versionUpdatedAt <= versionUpdated
    }
}