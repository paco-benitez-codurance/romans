package roman.mapper

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks
import matchers._

class TwoRomanShould
    extends AnyFreeSpec
    with TableDrivenPropertyChecks
    with should.Matchers {

  val mapping = BasicMapping(2)

  def check(decimal: Int, expected: String) = {
      s"$decimal should be $expected" in {
        mapping.roman(decimal).map(_.asString()).get shouldBe expected
      }
  }


  check(2, "II")
  check(20, "XX")
  check(200, "CC")
  check(2000, "MM")

}
