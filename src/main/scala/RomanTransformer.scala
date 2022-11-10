class RomanTransformer {
  def roman(number: Int): String = {
    val res =
      new BasicMapping() combine
      new TwoRoman() combine
      new ThreeRoman()

    return res.map(number).get.asString()
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
  def map(number: Int): Option[Roman]
  def combine(other: MapRoman): MapRoman = MapRoman.combineTwo(this, other)
}

object MapRoman {
  def combineTwo(one: MapRoman, another: MapRoman) = new MapRoman {
    override def map(number: Int): Option[Roman] =
      one.map(number) orElse another.map(number)
  }
}

class BasicMapping extends MapRoman {
  override def map(number: Int): Option[Roman] =
    for {
      bsc <- BasicTypes.toMap
        .get(number)
    } yield bsc
}

class ThreeRoman extends MapRoman {

  override def map(number: Int): Option[Roman] =
    findBasicMultipliedBy(3)(number).map(rom => rom + rom + rom)

  private def findBasicMultipliedBy(mult: Int)(number: Int): Option[Roman] =
    BasicTypes.reverse
      .find(_._1 * mult == number)
      .map(_._2)

}

class TwoRoman extends MapRoman {

  override def map(number: Int): Option[Roman] =
    findBasicMultipliedBy(2)(number).map(rom => rom + rom)

  private def findBasicMultipliedBy(mult: Int)(number: Int): Option[Roman] =
    BasicTypes.reverse
      .find(_._1 * mult == number)
      .map(_._2)

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
