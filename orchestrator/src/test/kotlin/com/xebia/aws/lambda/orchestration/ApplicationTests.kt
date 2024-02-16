package com.xebia.aws.lambda.orchestration

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

class ApplicationTests {

	@Test
	fun callLambda() {
		runBlocking { Orchestration.orchestrate() }
	}

}
