package com.github.meckesl.batch

import akka.actor.Actor

object TickActor {
  case object tick
}

class TickActor extends Actor {
  def receive: Receive = {
    case tick => println("Tick!")
  }
}