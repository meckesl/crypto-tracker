package com.github.meckesl.batch

import com.github.meckesl.{CryptoDataInserter, CryptoTracker}

object InsertData extends App {

  CryptoDataInserter.insertData(CryptoTracker.holdings)

}
