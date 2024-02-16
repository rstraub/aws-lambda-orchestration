import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}

case class PipelineRequest(
    pipelineId: String
)

class Pipeline extends RequestHandler[PipelineRequest, String] {
  override def handleRequest(
      event: PipelineRequest,
      context: Context
  ): String = {
    val logger = context.getLogger
    logger.log("String found: " + event)
    "thank you for using the pipeline!"
  }
}
