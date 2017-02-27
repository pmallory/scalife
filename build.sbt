import Dependencies._

lazy val root = (project in file(".")).
  settings(
    name := "Life",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.scala-lang" % "scala-swing" % "2.10+"
  )
