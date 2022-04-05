import com.litesoftwares.coingecko.CoinGeckoApiClient
import com.litesoftwares.coingecko.domain.Coins.CoinList
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl

import java.util
import java.util.List

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("coinlist") {
    val client = new CoinGeckoApiClientImpl
    val coinList = client.getCoinList
    println(coinList)
  }
}
