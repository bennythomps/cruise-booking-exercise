package com.tst.cruisebooking

case class Promotion(code: String, notCombinableWith: Seq[String])

case class PromotionCombo(promotionCodes: Seq[String])

object Problem2 {
  def allCombinablePromotions(allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {
    def isCombinable(combo: Set[String]): Boolean = {
      combo.forall(code =>
        combo.forall(otherCode =>
          code == otherCode || !allPromotions.find(_.code == code).get.notCombinableWith.contains(otherCode)
        )
      )
    }

    def findMaxCombos(codes: Seq[String]): Seq[Set[String]] = {
      val allCombos = (1 to codes.length).flatMap(codes.combinations).map(_.toSet)
      allCombos.filter(isCombinable).filter(combo =>
        !allCombos.exists(other => combo.subsetOf(other) && combo != other && isCombinable(other))
      )
    }

    val allCodes = allPromotions.map(_.code)
    findMaxCombos(allCodes).map(combo => PromotionCombo(combo.toSeq.sorted))
  }

  def combinablePromotions(promotionCode: String, allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {
    allCombinablePromotions(allPromotions).filter(_.promotionCodes.contains(promotionCode))
  }

  def main(args: Array[String]): Unit = {
    val promotions = Seq(
      Promotion("P1", Seq("P3")),
      Promotion("P2", Seq("P4", "P5")),
      Promotion("P3", Seq("P1")),
      Promotion("P4", Seq("P2")),
      Promotion("P5", Seq("P2"))
    )

    println("All Promotion Combinations:")
    allCombinablePromotions(promotions).foreach(println)

    println("\nPromotion Combinations for P1:")
    combinablePromotions("P1", promotions).foreach(println)

    println("\nPromotion Combinations for P3:")
    combinablePromotions("P3", promotions).foreach(println)
  }
}
