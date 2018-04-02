package example

import akka.actor.{Actor, ActorSystem, PoisonPill, Props}

import scala.concurrent.duration._
import scala.concurrent.{Await, Promise}
import scala.util.Success

object ActorBasedApproach {
  val system = ActorSystem("HelloSystem")
  val base = system.actorOf(Props(classOf[Base], system), "base")

  def apply(i: Int): String = {
    val response: Promise[String] = Promise[String]()
    base ! Start(i, response)
    Await.result(response.future, 5000 millis)
  }
}

class Base(system: ActorSystem) extends Actor {

  val actors = List(
    system.actorOf(Props[DefaultActor], "default"),
    system.actorOf(Props[FizzActor], "fizz"),
    system.actorOf(Props[BuzzActor], "buzz"),
    system.actorOf(Props[FizzBuzzActor], "fizzbuzz"))

  var response: Promise[String] = _

  def say(i: Int): Unit = {
    actors.foreach(a => a ! Value(i))
  }

  override def receive: Receive = {
    case Start(i, response) =>
      this.response = response
      say(i)
    case Response(i, priority) => this.response.complete(Success(i))
  }
}

class DefaultActor extends Actor {
  override def receive: Receive = {
    case Value(i) => sender() ! Response("" + i, 0)
      self ! PoisonPill
  }
}

class FizzActor extends Actor {
  override def receive: Receive = {
    case Value(i) if i % 3 == 0 => sender() ! Response("fizz", 1)
      self ! PoisonPill
  }
}

class BuzzActor extends Actor {
  override def receive: Receive = {
    case Value(i) if i % 5 == 0 => sender() ! Response("buzz", 1)
      self ! PoisonPill
  }
}

class FizzBuzzActor extends Actor {
  override def receive: Receive = {
    case Value(i) if i % 15 == 0 => sender() ! Response("fizzbuzz", 2)
      self ! PoisonPill
  }
}

case class Value(i: Int)

case class Response(str: String, priority: Int)

case class Start(i: Int, response: Promise[String])
