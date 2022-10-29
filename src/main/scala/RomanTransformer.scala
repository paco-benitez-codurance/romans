class RomanTransformer {
  def roman(number: Int): String = {
    val decimal = DecimalNumber(number)
    decimal match
      case decimal: BasicDecimalNumber => decimal.toRoman().asString()
      case _                           => ???
  }
}
