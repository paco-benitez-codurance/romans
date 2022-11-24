import cats._
import cats.data._
import cats.implicits._

class CombinationOne() extends MapRoman {

  override def roman(number: Int): Option[Roman] = {
    Roman(Seq(X, X, I, X)).some
  }
}