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

resolvers += "jitpack" at "https://jitpack.io"
libraryDependencies += "com.github.Philipinho" % "CoinGecko-Java" % "master-SNAPSHOT"
libraryDependencies += "org.scalafx" %% "scalafx" % "16.0.0-R24"

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
    .map(m => "org.openjfx" % s"javafx-$m" % "16" classifier osName)
}
// https://mvnrepository.com/artifact/net.java.dev.openjfx/javafx-ui-charts
libraryDependencies += "net.java.dev.openjfx" % "javafx-ui-charts" % "1.3.1"

libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test