class DecimalNumber(number: Int) 

object DecimalNumber {
    def apply(number: Int): DecimalNumber = {
        if(number == 1) return BasicDecimalNumber(1, RomanNumber('I'))
        if(number == 5) return BasicDecimalNumber(1, RomanNumber('V'))
        ???
    }
}


class BasicDecimalNumber(number: Int, romanNumber: RomanNumber) extends DecimalNumber(number) {
    def toRoman(): RomanNumber = romanNumber
}

