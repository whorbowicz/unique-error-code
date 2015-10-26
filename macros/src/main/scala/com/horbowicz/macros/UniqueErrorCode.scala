package com.horbowicz.macros

import language.experimental.macros
import scala.reflect.macros.blackbox
import scala.language.dynamics


object UniqueErrorCode extends Dynamic {
  def selectDynamic(errorCode: String): String = macro ErrorCodeImpl.create
}

object ErrorCodeImpl {
  private var errorCodes = Set[String]()

  def create(c: blackbox.Context)
      (errorCode: c.Expr[String]): c.Expr[String] = {
    import c.universe._
    val value = c.eval(errorCode)
    if (!errorCodes(value)) {
      errorCodes = errorCodes + value
      reify(errorCode.splice)
    } else throw ErrorCodeDuplicated(value)
  }
}

case class ErrorCodeDuplicated(code: String)
  extends Exception(s"Duplicated error code: $code")