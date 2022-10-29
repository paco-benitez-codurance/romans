class DecimalNumber(number: Int)

object DecimalNumber {
  def apply(number: Int): DecimalNumber = {
    val isBasic = BasicDecimalNumber.basic.find(_.number == number)
    if (isBasic.isDefined) return isBasic.get
    ???
  }
}

class BasicDecimalNumber(val number: Int, val romanNumber: RomanNumber)
    extends DecimalNumber(number) {
  def toRoman(): RomanNumber = romanNumber
}

object BasicDecimalNumber {
  val basic = Seq(
    BasicDecimalNumber(1, RomanNumber('I')),
    BasicDecimalNumber(5, RomanNumber('V')),
    BasicDecimalNumber(10, RomanNumber('X')),
    BasicDecimalNumber(50, RomanNumber('L')),
    BasicDecimalNumber(100, RomanNumber('C')),
    BasicDecimalNumber(500, RomanNumber('D')),
    BasicDecimalNumber(1000, RomanNumber('M'))
  )
}
