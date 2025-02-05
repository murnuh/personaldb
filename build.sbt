val scala3Version = "3.6.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "personaldb",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.xerial" % "sqlite-jdbc" % "3.39.2.1",
      "com.typesafe.slick" %% "slick" % "3.5.2",
      "org.slf4j" % "slf4j-nop" % "2.0.16",
      "org.scalatest" %% "scalatest" % "3.2.19" % Test
      )
  )
