package example

object XtremConstraintsApproach {
  // No If
  // Only Void

  def say(i: Int, result: Result): Unit = {
    val ruleFizzBuzz: Map[Boolean, String] = Map(true -> "fizzbuzz")
    val ruleFizz: Map[Boolean, String] = Map(true -> "fizz")
    val ruleBuzz: Map[Boolean, String] = Map(true -> "buzz")
    result.value = ruleFizzBuzz.getOrElse(i % 15 == 0, ruleFizz.getOrElse(i % 3 == 0, ruleBuzz.getOrElse(i % 5 == 0, i + "")))
  }
}

case class Result(var value: String)
