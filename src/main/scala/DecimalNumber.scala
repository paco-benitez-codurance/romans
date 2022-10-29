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
    BasicDecimalNumber(1, BasicRomanNumber('I')),
    BasicDecimalNumber(5, BasicRomanNumber('V')),
    BasicDecimalNumber(10, BasicRomanNumber('X')),
    BasicDecimalNumber(50, BasicRomanNumber('L')),
    BasicDecimalNumber(100, BasicRomanNumber('C')),
    BasicDecimalNumber(500, BasicRomanNumber('D')),
    BasicDecimalNumber(1000, BasicRomanNumber('M'))
  )

  def basic(number: Int): Option[BasicDecimalNumber] = 
    BasicTypes.find(_.number == number)

}