package roman.mapper

import cats._
import cats.data._
import cats.implicits._

import roman.model._
import roman.model.given

class AddOneToLeft() extends MapRoman {
  def basic(number: Int): Option[(Int, Basic)] = {
    BasicTypes.reverse.find(_._1 == number)
  }
  override def roman(number: Int): Option[Roman] = {
    val solutions = for {
      basic <- BasicTypes
      right <- BasicTypes if(basic._1 > right._1 )
      if(basic._1 - right._1 == number)
    } yield Roman(right._2) |+|  Roman(basic._2)

    solutions.headOption
  }
}