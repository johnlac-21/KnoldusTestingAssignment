name := "UT-IT"

version := "0.1"

scalaVersion := "2.13.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % "test"
resolvers += "jitpack" at "https://jitpack.io"
//libraryDependencies += "com.github.barkhorn" % "ScalaMock" % "master-SNAPSHOT"
libraryDependencies += "org.scalamock" %% "scalamock" % "5.1.0" % Test

