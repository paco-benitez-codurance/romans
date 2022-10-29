class DecimalNumber(number: Int)

object DecimalNumber extends BasicDecimalNumberCollections {
  def apply(number: Int): DecimalNumber = 
    basic(number).getOrElse(???)
}

class BasicDecimalNumber(val number: Int, val romanNumber: RomanNumber)
    extends DecimalNumber(number) {
  def toRoman(): RomanNumber = romanNumber
}

trait BasicDecimalNumberCollections {
  private val BasicTypes = Seq(
    BasicDecimalNumber(1, RomanNumber('I')),
    BasicDecimalNumber(5, RomanNumber('V')),
    BasicDecimalNumber(10, RomanNumber('X')),
    BasicDecimalNumber(50, RomanNumber('L')),
    BasicDecimalNumber(100, RomanNumber('C')),
    BasicDecimalNumber(500, RomanNumber('D')),
    BasicDecimalNumber(1000, RomanNumber('M'))
  )

  def basic(number: Int): Option[BasicDecimalNumber] = 
    BasicTypes.find(_.number == number)

}