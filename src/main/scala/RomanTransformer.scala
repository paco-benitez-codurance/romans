import cats._
import cats.data._
import cats.implicits._

class RomanTransformer {

  def roman(number: Int): String = {

    val basic: MapRoman = BasicMapping(1)
    val two: MapRoman = BasicMapping(2)
    val three: MapRoman = BasicMapping(3)
    val addOneToRight: MapRoman = AddToRight(1)
    val addTwoToRight: MapRoman = AddToRight(2)
    val addThreeToRight: MapRoman = AddToRight(3)
    val addOneToLeft: MapRoman = AddOneToLeft()

    val res =
      basic |+| two |+| three |+| addOneToRight |+| addTwoToRight |+| addThreeToRight |+| addOneToLeft

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
