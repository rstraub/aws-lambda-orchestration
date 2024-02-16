package com.xebia.pipeline.orchestration

import com.amazonaws.services.lambda.runtime.{Context, RequestStreamHandler}

case class PipelineRequest(
    pipelineId: String
)

class Pipeline extends RequestStreamHandler {
  import java.io.{InputStream, OutputStream}

  private val scalaMapper = {
    import com.fasterxml.jackson.databind.ObjectMapper
    import com.fasterxml.jackson.module.scala.DefaultScalaModule
    new ObjectMapper().registerModule(new DefaultScalaModule)
  }

  override def handleRequest(
      input: InputStream,
      output: OutputStream,
      context: Context
  ): Unit = {
    val pipeline = scalaMapper.readValue(input, classOf[PipelineRequest])

    val logger = context.getLogger
    logger.log("Pipeline request found: " + pipeline.pipelineId)

    output.write(s"Thank you for running the pipeline: ${pipeline.pipelineId}".getBytes)
  }
}
