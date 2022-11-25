package roman.mapper

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks
import matchers._

import roman.model._

class AddOneToLeftShould
    extends AnyFreeSpec
    with should.Matchers {

  val mappingOne = AddOneToLeft()

  def check(mapping: MapRoman, decimal: Int, expected: String) = {
      s"$decimal should be $expected" in {
        mapping.roman(decimal).map(_.asString()).get shouldBe expected
      }
  }

  check(mappingOne, 4, "IV")
  check(mappingOne, 9, "IX")

}
