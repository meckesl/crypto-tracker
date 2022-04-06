package com.github.meckesl

import com.litesoftwares.coingecko.domain.Coins.CoinFullData
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl

import scala.jdk.CollectionConverters.*
import java.util.Date

object CryptoTracker extends App {

  val client = new CoinGeckoApiClientImpl
  val allCoins = client.getCoinList.asScala
  println(allCoins.length + " coins in database")

  case class Holding(symbol: String, value: Double)
  case class Result(symbol: String, USDValue: Double, date: Date)

  def USDValue(c: CoinFullData) = c.getTickers.asScala.filter(_.getTarget.toUpperCase.equals("USD")).headOption.map(_.getLast).getOrElse(Double.NaN)

  val coins = Seq(Holding("BTC", 1), Holding("DOT", 2))

  val results =
    coins
      .map(c=> allCoins.filter(_.getSymbol.toLowerCase.equals(c.symbol.toLowerCase)).head)
      .map(d=> client.getCoinById(d.getId))
      .map(e=> Result(e.getSymbol, USDValue(e), new Date))

  print(results.mkString("\n"))

}