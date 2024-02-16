exports.handler = async (event) => {
    let body = JSON.parse(event.body)
    const product = body.pipelineId
    const response = {
        statusCode: 200,
        body: "Processed pipelineId " + body.pipelineId
    };
    return response;
};
