package com.xebia.aws.lambda.orchestration

import io.kotest.matchers.shouldBe
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class ApplicationTests {

	@Test
	fun callLambda(): Unit = runBlocking {
		 LambdaPipelineStep.run("1337") shouldBe "Thank you for running the pipeline: 1337"
	}

}
