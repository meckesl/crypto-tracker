package com.github.meckesl.batch

import akka.actor.{ActorSystem, Props}

import scala.concurrent.duration.*

object Scheduler extends App {

  val system = ActorSystem("TickActorSystem")
  val holdingsActor = system.actorOf(Props[HoldingsActor](), "holdingsActor")

  import system.dispatcher

  system.scheduler
    .scheduleAtFixedRate(0.day, 1.day, holdingsActor, "dailyRefresh")

}

