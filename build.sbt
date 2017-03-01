import Dependencies._

lazy val root = (project in file(".")).
  settings(
    name := "Life",
    libraryDependencies += "junit" % "junit" % "4.10" % "test",
    libraryDependencies += "org.scala-lang" % "scala-swing" % "2.10+",
	libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1",
	libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

  )
