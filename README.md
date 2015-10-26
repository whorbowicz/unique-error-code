unique-error-code
=============
The idea behind this macro is to provide a way to declare errors so that:
* Error can be declared and used with a meaningful name
* Error code is unique and this condition is checked at compile time
* Error can be declared in one line (single expression)

Given
`case class Error(code: String, message: String)`
you can declare your errors like this:
```
object Error {
    val MeaningfulName = Error(UniqueErrorCode.E001, "Message")
}
```
with compile time check that in this module `UniqueErrorCode.E001` is used once.
