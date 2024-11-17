package com.github.meckesl.batch

import akka.actor.{ActorSystem, Props}
import com.github.meckesl.batch.TickActor

import scala.concurrent.duration.*

object Scheduler extends App {

  val system = ActorSystem("TickActorSystem")
  val tickActor = system.actorOf(Props[TickActor](), "tickActor")

  import system.dispatcher // to get an execution context for the scheduler

  system.scheduler.scheduleAtFixedRate(0.seconds, 10.seconds, tickActor, "tick")

}

