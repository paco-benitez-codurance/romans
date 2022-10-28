import org.scalatest.freespec.AnyFreeSpec

import org.scalatest._
import matchers._


class RomansShould extends AnyFreeSpec with should.Matchers {
  "one should be an I" in {
    var roman = Roman()
    roman.roman(1) shouldBe "I"
  }
}
