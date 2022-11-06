package com.tft.apibatch.batch

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
internal class BatchConfigTest{

    @Autowired
    lateinit var job: Job
    @Autowired
    lateinit var jobLauncher : JobLauncher // proxy 객체


    @Test
    fun testJob() {
        val jobParameters = JobParametersBuilder()
            .addLong("collectSummonerIdCnt", 3)
            .addLong("collectPuuIdCnt", 50)
            .addLong("collectMatchIdCnt", 50)
            .addLong("collectMatchInfoCnt", 100)
            .addLong("collectDeckCnt", Int.MAX_VALUE.toLong() )
            .toJobParameters()

        val execution = jobLauncher.run(job, jobParameters)
        Assertions.assertThat(execution.exitStatus).isEqualTo(ExitStatus.COMPLETED)

    }
}