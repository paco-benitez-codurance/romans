
class RomanTransformer extends BasicMapping {
  def roman(number: Int): String = {
      basic(number)
      .map(_.asString())
      .getOrElse(???)
  }
}

trait BasicMapping {
  private val BasicTypes = Seq(
    (1, Roman.Basic('I')),
    (5, Roman.Basic('V')),
    (10, Roman.Basic('X')),
    (50, Roman.Basic('L')),
    (100, Roman.Basic('C')),
    (500, Roman.Basic('D')),
    (1000, Roman.Basic('M'))
  )

  def basic(number: Int): Option[Roman] = 
    BasicTypes
      .toMap
      .get(number)
}