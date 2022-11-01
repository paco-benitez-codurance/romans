abstract class Basic(character: Char) {
    def asString() = String.valueOf(character)
}

case object I extends Basic('I')
case object V extends Basic('V')
case object X extends Basic('X')
case object L extends Basic('L')
case object C extends Basic('C')
case object D extends Basic('D')
case object M extends Basic('M')

case class Roman(basics: Seq[Basic]) {
    def asString() = basics.foldLeft("")(_ + _.asString())

    def +(that: Roman) = Roman(this.basics ++ that.basics)
}

object Roman {
    def apply(basic: Basic): Roman = new Roman(Seq(basic))
}