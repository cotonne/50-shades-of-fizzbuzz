import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.4",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "50-shades-of-fizzbuzz",
    libraryDependencies += scalaTest % Test
    , libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.0"
    , libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.16"
  )
