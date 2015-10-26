package com.horbowicz.examples

import com.horbowicz.macros.UniqueErrorCode

object ErrorCodeExample extends App {
  val SampleError = Error(UniqueErrorCode.E001, "Error message")
  println(SampleError)
//  val CompilationFailed = Error(UniqueErrorCode.E001, "This line does not compile")
}

case class Error(code: String, message: String)