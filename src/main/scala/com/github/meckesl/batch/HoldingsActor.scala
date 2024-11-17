package com.github.meckesl.batch

import akka.actor.Actor
import com.github.meckesl.dao.HoldingDAO
import com.github.meckesl.model.Holding

import java.util.Date

object HoldingsActor {
  case object dailyRefresh
}

class HoldingsActor extends Actor {
  
  def receive: Receive = {
    
    case dailyRefresh =>
      lazy val holdings: Seq[Holding] =
        Seq(
          Holding("btc", 0.031077),
          Holding("mana", 19),
          Holding("near", 12.85),
        )
      HoldingDAO.insertData(holdings, "louis", new java.sql.Date(new Date().getTime))
      
  }
  
}