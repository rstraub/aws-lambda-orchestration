package com.xebia.pipeline.orchestration

import com.xebia.pipeline.orchestration.aws.LambdaPipelineStep
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        LambdaPipelineStep.run("1337").let(::println)
    }
}
