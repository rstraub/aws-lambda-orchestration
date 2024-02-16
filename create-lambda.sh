#!/bin/bash
zip function.zip index.js
awslocal lambda create-function \
    --function-name lambda-part \
    --runtime nodejs18.x \
    --zip-file fileb://function.zip \
    --handler index.handler \
    --role arn:aws:iam::000000000000:role/lambda-role
