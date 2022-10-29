trait RomanNumber {
    def asString(): String
}

final case class BasicRomanNumber(char: Char) extends RomanNumber {
    def asString(): String = String.valueOf(char)
}
