import cats._
import cats.data._
import cats.implicits._

class BasicMapping extends MapRoman {
  override def roman(number: Int): Option[Roman] =
    RomanUtil.findBasicMultipliedBy(1)(number)
}