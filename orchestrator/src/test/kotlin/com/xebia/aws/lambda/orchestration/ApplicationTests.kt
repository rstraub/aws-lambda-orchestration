package com.xebia.aws.lambda.orchestration

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class ApplicationTests {

	@Test
	fun callLambda() {
		runBlocking { Orchestration.orchestrate() }
	}

}
