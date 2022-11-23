import org.scalatest.freespec.AnyFreeSpec
import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks
import matchers._

class AddToRightShould
    extends AnyFreeSpec
    with TableDrivenPropertyChecks
    with should.Matchers {

  val mappingOne = AddToRight(1)
  val mappingTwo = AddToRight(2)
  val mappingThree = AddToRight(3)

  def check(mapping: MapRoman, decimal: Int, expected: String) = {
      s"$decimal should be $expected" in {
        mapping.roman(decimal).map(_.asString()).get shouldBe expected
      }
  }


  check(mappingOne, 6, "VI")
  check(mappingOne, 11, "XI")
  check(mappingOne, 15, "XV")

  check(mappingTwo, 12, "XII")

  check(mappingThree, 13, "XIII")

}
