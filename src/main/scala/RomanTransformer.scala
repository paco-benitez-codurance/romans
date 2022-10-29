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
  def basic(number: Int): Option[Roman] =
    BasicTypes.toMap
      .get(number)
}

trait SimpleCombination {
  def simple(number: Int): Option[Roman] = Some(
    I + I
  )
}
