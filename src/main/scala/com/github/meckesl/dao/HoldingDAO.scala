package com.github.meckesl.dao

import com.github.meckesl.model.Holding

import java.sql.*

object HoldingDAO extends AbstractDAO {

  def insertData(holdings: Seq[Holding], user: String, date: Date): Unit = {
    val connection = getConnection
    val statement = connection.createStatement

    holdings.foreach { h =>
      val sql: String =
        s"""
           |INSERT INTO holdings (symbol, amount, cryptouser, date)
           |VALUES ('${h.symbol}', ${h.amount}, '$user', '$date')
           |""".stripMargin

      statement.executeUpdate(sql)
      println(sql)

    }

    statement.close()
    connection.close()
  }
}