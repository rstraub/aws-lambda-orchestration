package com.xebia.pipeline.orchestration

import com.xebia.pipeline.orchestration.aws.LambdaPipelineStep
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ApplicationTests {
    private lateinit var pipelineStep: PipelineStep

    @Test
    fun `call lambda step`(): Unit = runBlocking {
        pipelineStep = LambdaPipelineStep
        pipelineStep.run("1337") shouldBe "Thank you for running the pipeline: 1337"
    }

    @Test
    fun `call local step`(): Unit = runBlocking {
        pipelineStep = LocalPipelineStep
        pipelineStep.run("1337") shouldBe "Thank you for running the pipeline: 1337"
    }
}
