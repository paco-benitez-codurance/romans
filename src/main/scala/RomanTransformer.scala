
class RomanTransformer extends BasicMapping {
  def roman(number: Int): String = {
      basic(number)
      .map(roman => roman.asString())
      .getOrElse(???)
  }
}

trait BasicMapping {
  private val BasicTypes = Seq(
    Tuple2(1, Roman.Basic('I')),
    Tuple2(5, Roman.Basic('V')),
    Tuple2(10, Roman.Basic('X')),
    Tuple2(50, Roman.Basic('L')),
    Tuple2(100, Roman.Basic('C')),
    Tuple2(500, Roman.Basic('D')),
    Tuple2(1000, Roman.Basic('M'))
  )

  def basic(number: Int): Option[Roman] = 
    BasicTypes.find(_._1 == number).map(pair => pair._2)
}