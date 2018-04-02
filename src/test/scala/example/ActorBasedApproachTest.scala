package example

import org.scalatest.{FlatSpec, FunSuite, Matchers}

class ActorBasedApproachTest extends FlatSpec with Matchers {
  it should "1" in {
    ActorBasedApproach(1) shouldEqual "1"
  }

  it should "3" in {
    ActorBasedApproach(3) shouldEqual "fizz"
  }

  it should "5" in {
    ActorBasedApproach(5) shouldEqual "buzz"
  }

  it should "15" in {
    ActorBasedApproach(15) shouldEqual "fizzbuzz"
  }
}
