name := "mimirtypeDetect"
version := "0.1"
scalaVersion := "2.12.6"


scalaVersion := "2.12.6"

javaOptions += "-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"

libraryDependencies += "org.specs2" %% "specs2-core" % "4.3.4" % "test"

scalacOptions in Test ++= Seq("-Yrangepos")


libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.5"

