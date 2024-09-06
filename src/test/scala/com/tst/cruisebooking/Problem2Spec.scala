package com.tst.cruisebooking

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem2Spec extends AnyFlatSpec with Matchers {
  val promotions = Seq(
    Promotion("P1", Seq("P3")),
    Promotion("P2", Seq("P4", "P5")),
    Promotion("P3", Seq("P1")),
    Promotion("P4", Seq("P2")),
    Promotion("P5", Seq("P2"))
  )

  "allCombinablePromotions" should "return all possible promotion combinations" in {
    val expected = Set(
      PromotionCombo(Seq("P1", "P2")),
      PromotionCombo(Seq("P1", "P4", "P5")),
      PromotionCombo(Seq("P2", "P3")),
      PromotionCombo(Seq("P3", "P4", "P5"))
    )

    val result = Problem2.allCombinablePromotions(promotions).toSet
    result shouldEqual expected
  }

  it should "handle empty input correctly" in {
    val result = Problem2.allCombinablePromotions(Seq.empty)
    result shouldBe empty
  }

  it should "handle a single promotion correctly" in {
    val singlePromotion = Seq(Promotion("P1", Seq.empty))
    val expected = Seq(PromotionCombo(Seq("P1")))

    val result = Problem2.allCombinablePromotions(singlePromotion)
    result shouldEqual expected
  }

  "combinablePromotions" should "return all combinations for a given promotion code" in {
    val expectedP1 = Set(
      PromotionCombo(Seq("P1", "P2")),
      PromotionCombo(Seq("P1", "P4", "P5"))
    )

    val resultP1 = Problem2.combinablePromotions("P1", promotions).toSet
    resultP1 shouldEqual expectedP1

    val expectedP3 = Set(
      PromotionCombo(Seq("P2", "P3")),
      PromotionCombo(Seq("P3", "P4", "P5"))
    )

    val resultP3 = Problem2.combinablePromotions("P3", promotions).toSet
    resultP3 shouldEqual expectedP3
  }

  it should "return an empty sequence for non-existent promotion code" in {
    val result = Problem2.combinablePromotions("NonExistent", promotions)
    result shouldBe empty
  }
}
