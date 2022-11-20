package com.tft.apibatch.batch

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.Job
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
            .addLong("willSavedSummonerIdCnt", 10)
            .addLong("willUpdatedPuuIdCnt", 10)
            .addLong("willSavedMatchCnt", 100)
            .addLong("willUpdatedMatchCnt", 100)
            .addLong("willConvertedMatchCnt", 100)
            .toJobParameters()

        val execution = jobLauncher.run(collectJob, jobParameters)
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