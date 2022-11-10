import cats._
import cats.data._
import cats.implicits._


class RomanTransformer {

  def roman(number: Int): String = {

    val basic: MapRoman = BasicMapping()
    val two: MapRoman = TwoRoman()
    val three: MapRoman = ThreeRoman()

    val res =
      basic |+| two |+| three

    return res.roman(number).get.asString()
  }
}

val BasicTypes = Seq(
  (1, I),
  (5, V),
  (10, X),
  (50, L),
  (100, C),
  (500, D),
  (1000, M)
)
trait MapRoman {
  def roman(number: Int): Option[Roman]
}

given semigroupRomans: Semigroup[MapRoman] with {
  def combine(x: MapRoman, y: MapRoman): MapRoman = new MapRoman {
    override def roman(number: Int): Option[Roman] =
      x.roman(number) orElse y.roman(number)
  }
}

object RomanUtil {
   def findBasicMultipliedBy(mult: Int)(number: Int): Option[Roman] =
    BasicTypes.reverse
      .find(_._1 * mult == number)
      .map(_._2)
}

class BasicMapping extends MapRoman {
  override def roman(number: Int): Option[Roman] =
    RomanUtil.findBasicMultipliedBy(1)(number)
}

class ThreeRoman extends MapRoman {
  override def roman(number: Int): Option[Roman] =
    RomanUtil.findBasicMultipliedBy(3)(number).map(rom => rom |+| rom |+| rom)
}

class TwoRoman extends MapRoman {
  override def roman(number: Int): Option[Roman] =
    RomanUtil.findBasicMultipliedBy(2)(number).map(rom => rom |+| rom)
}

/*
class AddOneMinorToRight extends MapRoman {
  val basic = new BasicMapping()
  val two = new TwoRoman()
  val three = new ThreeRoman()
  override def map(number: Int): Option[Roman] = {
    for {
      bas <- basic.map(5)
      remaining <- basic.map(number - 5) orElse three.map(number - 5) orElse two
        .map(number - 5)
    } yield bas + remaining
  }
}
 */
