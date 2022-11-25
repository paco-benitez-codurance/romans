package roman

import cats._
import cats.data._
import cats.implicits._

trait MapRoman {
  def roman(number: Int): Option[Roman]
}