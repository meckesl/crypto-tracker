package com.github.meckesl

import com.litesoftwares.coingecko.domain.Coins.CoinFullData
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl

import scala.jdk.CollectionConverters.*
import java.util.Date

object CryptoTracker extends App {

  private def marketValue(c: CoinFullData, currency: String = "eur") =
    c.getMarketData.getCurrentPrice.asScala(currency)

  val client = new CoinGeckoApiClientImpl
  val allCoins = client.getCoinList.asScala

  lazy val holdings: Seq[Holding] =
    Seq(
      Holding("btc", 0.031077),
      Holding("mana", 19),
      Holding("near", 12.85),
    )

  def res(holdings: Seq[Holding]) =
    holdings
      .groupBy(_.symbol).map { case (s,a) => Holding(s, a.map(_.amount).sum) }
      .map(h => (h, allCoins.filter(_.getSymbol.toLowerCase.equals(h.symbol.toLowerCase)).head))
      .map(h => (h._1, client.getCoinById(h._2.getId)))
      .map(h => Holding(h._1.symbol, h._1.amount * marketValue(h._2)))
      .toList
      .sortBy(_.amount)
      .reverse

  val result = res(holdings)
  println(result.mkString("\n"))
  println(s"Total=${result.foldLeft(0.0){(acc, h) => acc + h.amount}}")

}