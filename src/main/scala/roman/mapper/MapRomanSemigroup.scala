package roman.mapper

import cats._
import cats.data._
import cats.implicits._

import roman.model._

given semigroupRomans: Semigroup[MapRoman] with {
  def combine(x: MapRoman, y: MapRoman): MapRoman = new MapRoman {
    override def roman(number: Int): Option[Roman] =
      x.roman(number) orElse y.roman(number)
  }
}
