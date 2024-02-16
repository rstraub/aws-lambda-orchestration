package com.xebia.aws.lambda.orchestration

import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider
import aws.sdk.kotlin.services.lambda.LambdaClient
import aws.sdk.kotlin.services.lambda.model.InvokeRequest
import aws.sdk.kotlin.services.lambda.model.LogType
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider
import aws.smithy.kotlin.runtime.net.url.Url

object Orchestration {

    suspend fun orchestrate() {
        val req = InvokeRequest {
            functionName = "lambda-part"
            logType = LogType.Tail
            payload = "{\"pipelineId\": \"10\"}".encodeToByteArray()
        }
        LambdaClient {
            region = "us-east-1"
            endpointUrl = Url.parse("http://localhost:4566")
            credentialsProvider = StaticCredentialsProvider {
                accessKeyId = "accesskey"
                secretAccessKey = "secretkey"
            }
        }.use { client ->
            val res = client.invoke(req)
            println(res.payload?.decodeToString())
            res.logResult
        }
    }
}
