name := "CookieJarBackend"

version := "1.0"

scalaVersion := "2.11.8"




lazy val http4sVersion = "0.14.1"

// Only necessary for SNAPSHOT releases
resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion,
  "com.typesafe.slick" %% "slick" % "3.1.1",
  "org.typelevel" %% "cats" % "0.6.1"

)
    