import org.scalatest.freespec.AnyFreeSpec

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks
import matchers._

class RomansShould
    extends AnyFreeSpec
    with TableDrivenPropertyChecks
    with should.Matchers {

  val basicNumber =
    Table(
      ("decimal", "roman"),
      (1, 'I'),
      (5, 'V')
    )

  forAll(basicNumber) { (decimal, roman) => {
      s"basic number $decimal should be $roman" in {
        RomanTransformer.roman(DecimalNumber(decimal)) shouldBe RomanNumber(roman)
      }
    }
  }
}
