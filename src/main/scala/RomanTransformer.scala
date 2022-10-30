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
    if (number % 10 == 0 && number / 10 == 2) {
      return duplicate(10)
    } else if (number % 10 == 0 && number / 10 == 3) {
      return triplicate(10)
    } else if (number % 2 == 0) {
      return duplicate(1)
    } else if (number % 3 == 0) {
      return Some(I + I + I)
    } else {
      return None
    }
  }

  def duplicate(base: Int) =
    for {
      candidateBasic <- basic(base)
    } yield candidateBasic + candidateBasic


  def triplicate(base: Int) =
    for {
      candidateBasic <- basic(base)
    } yield candidateBasic + candidateBasic + candidateBasic
}
