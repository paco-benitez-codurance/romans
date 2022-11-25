package roman

import cats._
import cats.data._
import cats.implicits._

import roman.mapper.AllMappers
import roman.given

class RomanTransformer extends AllMappers {

  def roman(number: Int): String = {
    return allMappers.roman(number).get.asString()
  }
}

val BasicTypes: Seq[(Int, Basic)] = Seq(
  (1, I),
  (5, V),
  (10, X),
  (50, L),
  (100, C),
  (500, D),
  (1000, M)
)

given semigroupRomans: Semigroup[MapRoman] with {
  def combine(x: MapRoman, y: MapRoman): MapRoman = new MapRoman {
    override def roman(number: Int): Option[Roman] =
      x.roman(number) orElse y.roman(number)
  }
}
