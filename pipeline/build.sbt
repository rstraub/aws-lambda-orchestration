ThisBuild / organization := "com.xebia"
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

val circeVersion = "0.14.1"
lazy val root = (project in file("."))
  .settings(
    name := "aws.lambda.pipeline",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.2.2",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "3.11.1",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-log4j2" % "1.5.1",
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion,
      "io.circe" %% "circe-parser" % circeVersion
    ),
    libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.16.1",
    assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x                             => MergeStrategy.first
    }
  )
