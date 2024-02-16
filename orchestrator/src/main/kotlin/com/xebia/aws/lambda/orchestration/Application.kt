package com.xebia.aws.lambda.orchestration

import kotlinx.coroutines.runBlocking

class Application

fun main(args: Array<String>) {
    runBlocking {
        Orchestration.orchestrate()
    }
}
