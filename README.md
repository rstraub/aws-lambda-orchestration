# aws-lambda-orchestration

```bash
awslocal lambda invoke --function-name lambda-part \
--cli-binary-format raw-in-base64-out \
--payload '{"body": "{\"pipelineId\": \"10\"}"}' output.txt
```