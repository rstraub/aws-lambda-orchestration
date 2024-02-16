package com.xebia.aws.lambda.orchestration

import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        Orchestration.orchestrate().let(::println)
    }
}
