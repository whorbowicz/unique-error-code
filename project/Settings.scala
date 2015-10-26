import sbt._
import Keys._

object Settings {
  val common = Seq(
    scalaVersion := "2.11.7",
    version := "1.0"
  )
}