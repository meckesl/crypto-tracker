package com.github.meckesl

import com.litesoftwares.coingecko.domain.Coins.CoinFullData
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl

import scala.jdk.CollectionConverters.*
import java.util.Date

object CryptoTracker extends App {

  def marketValue(c: CoinFullData, currency: String = "eur") =
    c.getMarketData.getCurrentPrice.asScala(currency)

  val client = new CoinGeckoApiClientImpl
  val allCoins = client.getCoinList.asScala

  case class Holding(symbol: String, amount: Double)

  val holdings: Seq[Holding] =
    Seq(
      Holding("btc", 0.031077),
      Holding("mana", 18),
      Holding("near", 12.85),
      Holding("theta", 87.47),
      Holding("dock", 2200),
      Holding("dot", 20.06),
      Holding("sand", 61),
      Holding("dot", 13.38),
      Holding("bnb", 0.2388),
      Holding("dock", 79),
      Holding("sol", 3),
      Holding("ada", 299.5),
      Holding("sand", 50),
      Holding("cake", 10),
      Holding("near", 25),
      Holding("ada", 200),
      Holding("dot", 10),
      Holding("luna", 5),
      Holding("bnb", 1.026),
      Holding("btc", 0.00936),
      Holding("ftm", 500)
    )

  val res =
    holdings
      .groupBy(_.symbol).map { case (s,a) => Holding(s, a.map(_.amount).sum) }
      .map(h => (h, allCoins.filter(_.getSymbol.toLowerCase.equals(h.symbol.toLowerCase)).head))
      .map(h => (h._1, client.getCoinById(h._2.getId)))
      .map(h => Holding(h._1.symbol, h._1.amount * marketValue(h._2)))
      .toList
      .sortBy(_.amount)
      .reverse

  println(res.mkString("\n"))
  println(s"Total=${res.foldLeft(0.0){(acc, num) => acc + (num.amount)}}")

}