package com.xebia.pipeline.orchestration

interface PipelineStep {
    suspend fun run(pipelineId: String): String?
}
