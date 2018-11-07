name := "cafe"

version := "0.1"

scalaVersion := "2.12.7"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "aolins",
      scalaVersion := "2.12.4"
    )),
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.5" % Test,
      "org.mockito" % "mockito-all" % "1.9.5" % Test,
      "org.scalacheck" %% "scalacheck" % "1.12.6" % Test

    )
  )