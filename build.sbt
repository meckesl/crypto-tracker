name := "crypto-tracker"
version := "0.1.0-SNAPSHOT"
scalaVersion := "3.1.1"
organization := "com.github.meckesl"
homepage := Some(url("https://github.com/meckesl/crypto-tracker"))
developers := List(
  Developer(
    id = "meckesl",
    name = "Louis Meckes",
    email = "louis.meckes@gmx.com",
    url = url("http://github.com/meckesl")
  )
)

mainClass := Some("com.github.meckesl.CryptoTracker")

libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test