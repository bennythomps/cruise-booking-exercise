package com.tst.cruisebooking

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem1Spec extends AnyFlatSpec with Matchers {
  "getBestGroupPrices" should "return the best price for each cabin and rate group combination" in {
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

    val expectedOutput = Seq(
      BestGroupPrice("CA", "M1", BigDecimal("200.00"), "Military"),
      BestGroupPrice("CA", "S1", BigDecimal("225.00"), "Senior"),
      BestGroupPrice("CB", "M1", BigDecimal("230.00"), "Military"),
      BestGroupPrice("CB", "S1", BigDecimal("245.00"), "Senior")
    )

    val result = Problem1.getBestGroupPrices(rates, prices)
    result should contain theSameElementsAs expectedOutput
  }

  it should "handle empty input correctly" in {
    val emptyRates = Seq.empty[Rate]
    val emptyPrices = Seq.empty[CabinPrice]

    val result = Problem1.getBestGroupPrices(emptyRates, emptyPrices)
    result shouldBe empty
  }

  it should "handle a single rate and price correctly" in {
    val singleRate = Seq(Rate("R1", "Standard"))
    val singlePrice = Seq(CabinPrice("C1", "R1", BigDecimal("100.00")))

    val expectedOutput = Seq(BestGroupPrice("C1", "R1", BigDecimal("100.00"), "Standard"))

    val result = Problem1.getBestGroupPrices(singleRate, singlePrice)
    result should contain theSameElementsAs expectedOutput
  }
}
