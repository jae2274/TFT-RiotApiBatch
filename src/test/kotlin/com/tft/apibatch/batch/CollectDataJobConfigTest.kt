package com.tft.apibatch.batch

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource


@SpringBootTest
internal class CollectDataJobConfigTest {

    @Resource(name = "collectJob")
    lateinit var collectJob: Job


    @Resource(name = "staticDataJob")
    lateinit var staticDataJob: Job

    @Autowired
    lateinit var jobLauncher: JobLauncher // proxy 객체


    @Test
    @Order(1)
    fun testCollectJob() {
        val jobParameters = JobParametersBuilder()
                .addLong("willSavedSummonerIdCnt", 50)
                .addLong("willUpdatedPuuIdCnt", 50)
                .addLong("willSavedMatchCnt", 1000)
                .addLong("willUpdatedMatchCnt", 1000)
                .addLong("willConvertedMatchCnt", 1000)
                .toJobParameters()

        var execution = jobLauncher.run(collectJob, jobParameters)
        Assertions.assertThat(execution.exitStatus).isEqualTo(ExitStatus.COMPLETED)

        execution = jobLauncher.run(staticDataJob, JobParameters())
        Assertions.assertThat(execution.exitStatus).isEqualTo(ExitStatus.COMPLETED)
    }


    @Test
    @Order(2)
    fun testStaticDataJob() {
        val jobParameters = JobParametersBuilder()
                .toJobParameters()

        val execution = jobLauncher.run(staticDataJob, jobParameters)
        Assertions.assertThat(execution.exitStatus).isEqualTo(ExitStatus.COMPLETED)

    }
}