package example

import org.scalatest.{FlatSpec, Matchers}

class XtremConstraintsApproachTest extends FlatSpec with Matchers {
  behavior of "XtremConstraintsApproach"

  it should "say the value" in {
    val result: Result = Result("")
    XtremConstraintsApproach.say(1, result)
    result.value shouldEqual "1"
  }

  it should "say fizz for a multiple of 3" in {
    val result: Result = Result("")
    XtremConstraintsApproach.say(3, result)
    result.value shouldEqual "fizz"
  }

  it should "say buzz for a multiple of 5" in {
    val result: Result = Result("")
    XtremConstraintsApproach.say(5, result)
    result.value shouldEqual "buzz"
  }

  it should "say buzz for a multiple of 15" in {
    val result: Result = Result("")
    XtremConstraintsApproach.say(15, result)
    result.value shouldEqual "fizzbuzz"
  }
}
