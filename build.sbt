import scala.io._
name := "crypto-tracker"
version := Source.fromFile(s"${baseDirectory.value.getAbsolutePath}/version").mkString.trim
scalaVersion := "3.1.2"
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

fork := true

resolvers += "jitpack" at "https://jitpack.io"
libraryDependencies += "com.github.Philipinho" % "CoinGecko-Java" % "master-SNAPSHOT"

// https://mvnrepository.com/artifact/org.openjfx/javafx
libraryDependencies += "org.openjfx" % "javafx" % "18" pomOnly()
libraryDependencies ++= {
  lazy val osName = System.getProperty("os.name") match {
    case n if n.startsWith("Linux") => "linux"
    case n if n.startsWith("Mac") => "mac"
    case n if n.startsWith("Windows") => "win"
    case _ => throw new Exception("Unknown platform!")
  }
  Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
    .map(m => "org.openjfx" % s"javafx-$m" % "18" classifier osName)
}

libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test