import cats._
import cats.data._
import cats.implicits._

class AddOneToRight() extends MapRoman {
  def basic(number: Int): Option[(Int, Basic)] = {
    BasicTypes.reverse.find(_._1 == number)
  }
  override def roman(number: Int): Option[Roman] = {
    for {
      base <- basic(number - 1)
      remaining <- basic(number - base._1)
    } yield Roman(base._2) |+| Roman(remaining._2)
  }
}