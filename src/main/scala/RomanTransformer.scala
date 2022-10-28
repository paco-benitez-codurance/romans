object RomanTransformer {
 def roman(decimal: DecimalNumber): RomanNumber = {
    if(decimal == DecimalNumber(1)) return RomanNumber('I')
    if(decimal == DecimalNumber(5)) return RomanNumber('V')
    ???
 }
}
