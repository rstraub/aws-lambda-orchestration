package com.xebia.aws.lambda.orchestration

import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        LambdaPipelineStep.run("1337").let(::println)
    }
}
