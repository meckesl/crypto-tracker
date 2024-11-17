package com.github.meckesl

import java.sql.*

object CryptoDataInserter {

  private val url = "jdbc:postgresql://localhost:5432/cryptotracker"
  private val user = "postgres"
  private val password = "admin"

  private def getConnection: Connection = DriverManager.getConnection(url, user, password)

  def insertData(cryptoData: Seq[Holding]): Unit = {
    val connection = getConnection
    val statement = connection.createStatement

    cryptoData.foreach { h =>
      val sql =
        s"""
           |INSERT INTO holdings (symbol, amount)
           |VALUES ('${h.symbol}', ${h.amount})
           |""".stripMargin
      statement.executeUpdate(sql)
    }

    statement.close()
    connection.close()
  }
}