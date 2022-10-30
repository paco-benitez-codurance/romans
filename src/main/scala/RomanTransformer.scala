class RomanTransformer extends BasicMapping with SimpleCombination {
  def roman(number: Int): String = {
    val res = basic(number) orElse simple(number)
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
  def basic(number: Int): Option[Basic] =
    BasicTypes.toMap
      .get(number)
}

trait SimpleCombination extends BasicMapping {

  def simple(number: Int): Option[Roman] = {

    val three = BasicTypes.reverse
      .find(_._1 * 3 == number)
      .map((_, rom) => rom + rom + rom)

    val two =
      BasicTypes.reverse
      .find(_._1 * 2 == number)
      .map((_, rom) => rom + rom)

    three orElse two
  }

}
