package com.tst.cruisebooking

case class Rate(rateCode: String, rateGroup: String)

case class CabinPrice(cabinCode: String, rateCode: String, price: BigDecimal)

case class BestGroupPrice(cabinCode: String, rateCode: String, price: BigDecimal, rateGroup: String)

object Problem1 {
  def getBestGroupPrices(rates: Seq[Rate], prices: Seq[CabinPrice]): Seq[BestGroupPrice] = {
    val rateGroupMap = rates.map(r => r.rateCode -> r.rateGroup).toMap

    prices
      .groupBy(p => (p.cabinCode, rateGroupMap(p.rateCode)))
      .flatMap { case ((cabinCode, rateGroup), groupPrices) =>
        groupPrices.minBy(_.price) match {
          case CabinPrice(_, rateCode, price) =>
            Some(BestGroupPrice(cabinCode, rateCode, price, rateGroup))
        }
      }
      .toSeq
      .sortBy(bgp => (bgp.cabinCode, bgp.rateGroup))
  }

  def main(args: Array[String]): Unit = {
    val rates = Seq(
      Rate("M1", "Military"),
      Rate("M2", "Military"),
      Rate("S1", "Senior"),
      Rate("S2", "Senior")
    )

    val prices = Seq(
      CabinPrice("CA", "M1", BigDecimal("200.00")),
      CabinPrice("CA", "M2", BigDecimal("250.00")),
      CabinPrice("CA", "S1", BigDecimal("225.00")),
      CabinPrice("CA", "S2", BigDecimal("260.00")),
      CabinPrice("CB", "M1", BigDecimal("230.00")),
      CabinPrice("CB", "M2", BigDecimal("260.00")),
      CabinPrice("CB", "S1", BigDecimal("245.00")),
      CabinPrice("CB", "S2", BigDecimal("270.00"))
    )

    val bestPrices = getBestGroupPrices(rates, prices)
    println("Best Group Prices:")
    bestPrices.foreach(println)
  }
}