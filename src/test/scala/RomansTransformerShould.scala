import org.scalatest.freespec.AnyFreeSpec

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks
import matchers._

class RomansTransformerShould
    extends AnyFreeSpec
    with TableDrivenPropertyChecks
    with should.Matchers {

  val mapping = RomanTransformer()

  def check(decimal: Int, expected: String) = {
    s"$decimal should be $expected" in {
      mapping.roman(decimal) shouldBe expected
    }
  }

  check(1, "I")
  check(2, "II")
  check(6, "VI")
  check(7, "VII")
  check(8, "VIII")
  check(49, "IL")

  check(4, "IV")
  check(9, "IX")
  check(80, "LXXX")

  //check(29, "XXIX")
  //check(294, "CCXCIV")
  //check(2019, "MMXIX")
}
