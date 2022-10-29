import org.scalatest.freespec.AnyFreeSpec

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks
import matchers._

class RomansTransformerShould
    extends AnyFreeSpec
    with TableDrivenPropertyChecks
    with should.Matchers {

  val romanTransformer = RomanTransformer()

  val basicNumber =
    Table(
      ("decimal", "roman"),
      (1, I),
      (5, V),
      (10, X),
      (50, L),
      (100, C),
      (500, D),
      (1000, M)
    )

  forAll(basicNumber) { (decimal, roman) =>
    {
      s"basic number $decimal should be $roman" in {
        romanTransformer.roman(decimal) shouldBe String.valueOf(roman)
      }
    }
  }

  "Two should be II" in {
    romanTransformer.roman(2) shouldBe "II"
  }

  "Three should be III" in {
    romanTransformer.roman(3) shouldBe "III"
  }
}
