import cats._
import cats.data._
import cats.implicits._

class RomanTransformer {

  def roman(number: Int): String = {

    val basic: MapRoman = BasicMapping()
    val two: MapRoman = TwoRoman()
    val three: MapRoman = ThreeRoman()
    val addOneToRight: MapRoman = AddToRight(1)
    val addTwoToRight: MapRoman = AddToRight(2)
    val addThreeToRight: MapRoman = AddToRight(3)

    val res =
      basic |+| two |+| three |+| addOneToRight |+| addTwoToRight |+| addThreeToRight

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
