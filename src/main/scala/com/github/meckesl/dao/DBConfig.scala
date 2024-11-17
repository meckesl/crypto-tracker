package com.github.meckesl.dao

import java.sql.{Connection, DriverManager}

object DBConfig {
  
  val url = "jdbc:postgresql://localhost:5432/cryptotracker"
  val user = "postgres"
  val password = "admin"

  def getConnection: Connection = DriverManager.getConnection(url, user, password)
  
}
