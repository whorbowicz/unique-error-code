
lazy val root =
  (project in file("."))
    .settings(Settings.common)
    .settings(name := "unique-error-code")
    .aggregate(examples)

lazy val macros =
  (project in file("macros"))
    .settings(Settings.common: _*)
    .settings(
      name := "macros",
      libraryDependencies <+=
        scalaVersion("org.scala-lang" % "scala-compiler" % _)
    )

lazy val examples =
  (project in file("examples"))
    .settings(Settings.common: _*)
    .settings(name := "examples")
    .dependsOn(macros)