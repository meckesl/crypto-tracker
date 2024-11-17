import scala.io.Source
name := "crypto-tracker"
version := Source.fromFile(s"${baseDirectory.value.getAbsolutePath}/version").mkString.trim
scalaVersion := "3.5.0"
organization := "com.github.meckesl"
homepage := Some(url("https://github.com/meckesl/crypto-tracker"))
developers := List(
  Developer(
    id = "meckesl",
    name = "Louis Meckes",
    email = "louis.meckes@gmx.com",
    url = url("https://github.com/meckesl")
  )
)

fork := true

resolvers += "jitpack" at "https://jitpack.io"

libraryDependencies += "com.github.Philipinho" % "CoinGecko-Java" % "master-SNAPSHOT"
libraryDependencies += "org.postgresql" % "postgresql" % "42.7.3"
libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.8.5"