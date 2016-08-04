name := "CookieJarBackend"

version := "1.0"

scalaVersion := "2.11.8"

val circeVersion = "0.4.1"



lazy val http4sVersion = "0.14.1"

// Only necessary for SNAPSHOT releases
resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion,
  "org.http4s" %% "http4s-circe" % http4sVersion,
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "io.circe" %% "circe-java8" % circeVersion,
  "com.typesafe.slick" %% "slick" % "3.1.1",
  "org.slf4j" % "slf4j-log4j12" % "1.7.21",
  "com.typesafe" % "config" % "1.3.0",
  "mysql" % "mysql-connector-java" % "6.0.3"
)
