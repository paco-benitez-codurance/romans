import cats._
import cats.data._
import cats.implicits._

class CombinationOne() extends MapRoman {

  val base = Semigroup[MapRoman].combine(BasicMapping(1), BasicMapping(2))
  val oneLeft = AddOneToLeft()

  override def roman(number: Int): Option[Roman] =
    (number to 0 by -1)
      .map(hasRoman(_, number))
      .find(_.isDefined)
      .flatten

  private def hasRoman(i: Int, number: Int): Option[Roman] =
    for {
      part1 <- base.roman(i)
      part2 <- oneLeft.roman(number - i)
    } yield part1 |+| part2

}
