name := "Simple Stream"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.0.0"

libraryDependencies += "org.apache.spark" %% "spark-streaming" % "1.0.0"

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"
