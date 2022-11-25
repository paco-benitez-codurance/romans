package roman.mapper

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks
import matchers._

class ThreeRomanShould
    extends AnyFreeSpec
    with TableDrivenPropertyChecks
    with should.Matchers {

  val mapping = BasicMapping(3)

  def check(decimal: Int, expected: String) = {
      s"$decimal should be $expected" in {
        mapping.roman(decimal).map(_.asString()).get shouldBe expected
      }
  }


  check(3, "III")
  check(30, "XXX")
  check(300, "CCC")
  check(3000, "MMM")

}
