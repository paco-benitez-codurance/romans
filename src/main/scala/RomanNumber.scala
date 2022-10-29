trait Roman {
    def asString(): String
}

abstract class Basic(character: Char) extends Roman {
    def asString() = String.valueOf(character)
}

case object I extends Basic('I')
case object V extends Basic('V')
case object X extends Basic('X')
case object L extends Basic('L')
case object C extends Basic('C')
case object D extends Basic('D')
case object M extends Basic('M')

case class Compose(basics: Seq[Basic]) extends Roman {
    def asString() = basics.foldLeft("")(_ + _.asString())
}
