package roman.mapper

import org.scalatest.freespec.AnyFreeSpec

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks
import matchers._


import roman._

class BasicMappingShould
    extends AnyFreeSpec
    with TableDrivenPropertyChecks
    with should.Matchers {

  val romanTransformer = BasicMapping(1)

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

  def check(decimal: Int, expected: String) = {
      s"$decimal should be $expected" in {
        romanTransformer.roman(decimal).get.asString() shouldBe expected
      }
  }

  forAll(basicNumber) { (decimal, roman) =>
      check(decimal, roman.asString())
  }


}
