#!/bin/bash
(cd pipeline; sbt assembly)
awslocal lambda create-function \
    --function-name lambda-pipeline \
    --runtime java21 \
    --zip-file fileb://pipeline/target/scala-2.13/aws.lambda.pipeline-assembly-0.1.0-SNAPSHOT.jar \
    --handler com.xebia.aws.lambda.orchestration.Pipeline::handleRequest \
    --role arn:aws:iam::000000000000:role/lambda-role
