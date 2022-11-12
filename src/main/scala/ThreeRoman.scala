import cats._
import cats.data._
import cats.implicits._

class ThreeRoman extends MapRoman {
  override def roman(number: Int): Option[Roman] =
    RomanUtil.findBasicMultipliedBy(3)(number).map(rom => rom |+| rom |+| rom)
}