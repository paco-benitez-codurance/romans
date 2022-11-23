import org.scalatest.freespec.AnyFreeSpec
import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks
import matchers._

class AddOneToRightShould
    extends AnyFreeSpec
    with TableDrivenPropertyChecks
    with should.Matchers {

  val mapping = AddOneToRight()

  def check(decimal: Int, expected: String) = {
      s"$decimal should be $expected" in {
        mapping.roman(decimal).map(_.asString()).get shouldBe expected
      }
  }


  check(6, "VI")
  check(11, "XI")
  check(15, "XV")

}
