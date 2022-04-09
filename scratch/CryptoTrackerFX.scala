package com.github.meckesl

import com.litesoftwares.coingecko.domain.Coins.CoinFullData
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl

import java.util.Date
import scala.jdk.CollectionConverters.*

import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.scene.chart._
import scalafx.scene.shape.Rectangle

object HelloStageDemo extends JFXApp3 {

  override def start(): Unit = {

    val xAxis = new CategoryAxis

    stage = new JFXApp3.PrimaryStage {
      title.value = "Stacked Area Chart"
      width = 600
      height = 450
      scene = new Scene {
        fill = LightGreen
        content = new Rectangle {
          x = 25
          y = 40
          width = 100
          height = 100
          fill = Red
        }
      }
    }
  }

}