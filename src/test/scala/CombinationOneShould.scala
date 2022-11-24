import org.scalatest.freespec.AnyFreeSpec
import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks
import matchers._

class CombinationOneShould
    extends AnyFreeSpec
    with should.Matchers {

  val mapping = CombinationOne()

  def check(decimal: Int, expected: String) = {
      s"$decimal should be $expected" in {
        mapping.roman(decimal).map(_.asString()).get shouldBe expected
      }
  }

  check(29, "XXIX")

}
