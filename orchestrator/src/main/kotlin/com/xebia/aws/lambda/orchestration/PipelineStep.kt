package com.xebia.aws.lambda.orchestration

interface PipelineStep {
    suspend fun run(pipelineId: String): String?
}
