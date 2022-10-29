class RomanTransformer {
 def roman(decimal: DecimalNumber): RomanNumber = {
   decimal match
      case decimal: BasicDecimalNumber =>  decimal.toRoman()
      case _ => ???
 }
}
