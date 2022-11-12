import cats._
import cats.data._
import cats.implicits._

class RomanTransformer {

  def roman(number: Int): String = {

    val basic: MapRoman = BasicMapping()
    val two: MapRoman = TwoRoman()
    val three: MapRoman = ThreeRoman()
    val addOneToRight: AddOneToRight = AddOneToRight()

    val res =
      basic |+| two |+| three |+| addOneToRight

    return res.roman(number).get.asString()
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
      .map(x => Roman(x._2))
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

class AddOneToRight extends MapRoman {
  def basic(number: Int): Option[(Int, Basic)] = {
    BasicTypes.reverse.find(_._1 == number)
  }
  val basic = new BasicMapping()
  override def roman(number: Int): Option[Roman] = {
    for {
      base <- basic(number - 1)
      remaining <- basic.roman(number - base._1)
    } yield Roman(base._2) |+| remaining
  }
}
