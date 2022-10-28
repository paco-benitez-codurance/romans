import org.scalatest.freespec.AnyFreeSpec

import org.scalatest._
import matchers._


class RomansShould extends AnyFreeSpec with should.Matchers {
  "one should be an I" in {
    RomanTransformer.roman(DecimalNumber(1)) shouldBe RomanNumber('I')
  }
}
