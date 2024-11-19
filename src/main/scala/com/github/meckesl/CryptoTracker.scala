package com.github.meckesl

import com.github.meckesl.model.Holding
import com.litesoftwares.coingecko.domain.Coins.CoinFullData
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl

import scala.jdk.CollectionConverters.*
import scala.math.BigDecimal.RoundingMode

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
      .map((h, v) => Holding(h.symbol, h.amount * marketValue(v)))
      .toList
      .sortBy(_.amount)
      .reverse

  private val result = res(holdings)

  println("Assets")
  println("-----------------------")
  println(result.mkString("\n"))
  println("")
  println(s"Total = €${
    result.foldLeft(BigDecimal(0.0)){ (acc, h) =>
      acc + h.amount}.setScale(2, RoundingMode.HALF_UP)
  }")

}