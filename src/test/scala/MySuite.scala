import com.litesoftwares.coingecko.constant.Currency
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl

import scala.jdk.CollectionConverters.*

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {

  val client = new CoinGeckoApiClientImpl

  test("coinlist") {
    val coinList = client.getCoinList.asScala
    println(s"${coinList.length} coins found")
  }

  test("eurMarkets") {
    val markets = client.getCoinMarkets(Currency.EUR).asScala
    println(s"${markets.length} EUR markets found")
    println(markets.map(_.getSymbol).mkString(","))
  }

}
