package com.xebia.pipeline.orchestration

object LocalPipelineStep : PipelineStep {
    override suspend fun run(pipelineId: String): String? {
        return "Thank you for running the pipeline: $pipelineId"
    }
}
