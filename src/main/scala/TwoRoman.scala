import cats._
import cats.data._
import cats.implicits._

class TwoRoman extends MapRoman {
  override def roman(number: Int): Option[Roman] =
    RomanUtil.findBasicMultipliedBy(2)(number).map(rom => rom |+| rom)
}