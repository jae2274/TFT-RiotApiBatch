package com.tft.apibatch.batch

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
internal class BatchConfigTest {

    @Autowired
    lateinit var job: Job

    @Autowired
    lateinit var jobLauncher: JobLauncher // proxy 객체


    @Test
    fun testJob() {
        val jobParameters = JobParametersBuilder()
            .addLong("collectSummonerIdCnt", 1)
            .addLong("collectPuuIdCnt", 1)
            .addLong("collectMatchIdCnt", 1)
            .addLong("collectMatchInfoCnt", 1)
            .addLong("collectDeckCnt", 1)
            .toJobParameters()

        val execution = jobLauncher.run(job, jobParameters)
        Assertions.assertThat(execution.exitStatus).isEqualTo(ExitStatus.COMPLETED)

    }
}