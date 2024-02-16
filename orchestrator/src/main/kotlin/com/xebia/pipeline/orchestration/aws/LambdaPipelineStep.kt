package com.xebia.pipeline.orchestration.aws

import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider
import aws.sdk.kotlin.services.lambda.LambdaClient
import aws.sdk.kotlin.services.lambda.model.InvokeRequest
import aws.sdk.kotlin.services.lambda.model.LogType
import aws.smithy.kotlin.runtime.net.url.Url
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.xebia.pipeline.orchestration.PipelineStep

data class PipelineRequest(val pipelineId: String)

object LambdaPipelineStep : PipelineStep {
    private val mapper = jacksonObjectMapper()

    override suspend fun run(pipelineId: String): String? {
        val body = PipelineRequest(pipelineId)
        val json = mapper.writeValueAsString(body)

        val req = InvokeRequest {
            functionName = "lambda-pipeline"
            logType = LogType.Tail
            payload = json.encodeToByteArray()
        }

        return LambdaClient {
            region = "us-east-1"
            endpointUrl = Url.parse("http://localhost:4566")
            credentialsProvider = StaticCredentialsProvider {
                accessKeyId = "accesskey"
                secretAccessKey = "secretkey"
            }
        }.use { client ->
            val res = client.invoke(req)
            res.payload?.decodeToString()
        }
    }
}
