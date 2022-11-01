class RomanTransformer extends BasicMapping with RepeatedBasicMapping with AddOneMinorToRight {
  def roman(number: Int): String = {
    val res = basic(number) orElse repeatedBasic(number) orElse addMinorToRigth(number)
    res.map(_.asString()).getOrElse(???)
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

trait BasicMapping {
  def basic(number: Int): Option[Roman] =
    BasicTypes.toMap
      .get(number)
      .map(basic => Roman(basic))
}

trait RepeatedBasicMapping extends BasicMapping {

  def repeatedBasic(number: Int): Option[Roman] = {

    val three = findBasicMultipliedBy(3)(number).map(rom => rom + rom + rom)
    val two = findBasicMultipliedBy(2)(number).map(rom => rom + rom)

    three orElse two
  }

  private def findBasicMultipliedBy(mult: Int)(number: Int): Option[Roman] =
    BasicTypes.reverse
      .find(_._1 * mult == number)
      .map(bs => Roman(bs._2))

}

trait AddOneMinorToRight extends RepeatedBasicMapping {
  def addMinorToRigth(number: Int): Option[Roman] = {
    for {
      bas <- basic(5)
      remaining <- basic(number - 5) orElse repeatedBasic(number - 5)
    } yield bas + remaining
  }
}
