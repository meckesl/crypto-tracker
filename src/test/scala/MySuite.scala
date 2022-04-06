import com.litesoftwares.coingecko.CoinGeckoApiClient
import com.litesoftwares.coingecko.constant.Currency
import com.litesoftwares.coingecko.domain.Coins.CoinList
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl

import java.util
import java.util.List
import scala.jdk.CollectionConverters._

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {

  val client = new CoinGeckoApiClientImpl

  test("coinlist") {
    val coinList = client.getCoinList
    println(s"${coinList.size()} coins found")
  }

  test("eurMarkets") {
    val markets = client.getCoinMarkets(Currency.EUR).asScala
    println(s"${markets.length} EUR markets found")
    println(markets.map(_.getSymbol).mkString(","))
  }

}
