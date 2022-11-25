package roman.mapper

import cats._
import cats.data._
import cats.implicits._

import roman._
import roman.given

class AddToRight(elementsToRight: Int) extends MapRoman {
  def basic(number: Int): Option[(Int, Basic)] = {
    BasicTypes.reverse.find(_._1 == number)
  }
  override def roman(number: Int): Option[Roman] = {
    val solutions = for {
      basic <- BasicTypes
      right <- BasicTypes if(basic._1 > right._1 )
      if(basic._1 + (right._1 * elementsToRight) == number)
    } yield Roman(basic._2) |+| Semigroup.combineN(Roman(right._2), elementsToRight)


    solutions.headOption
  }
}