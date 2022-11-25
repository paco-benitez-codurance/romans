package roman

import cats._
import cats.data._
import cats.implicits._

import roman.mapper.AllMappers
import roman.model._

class RomanTransformer extends AllMappers {

  def roman(number: Int): String = {
    return allMappers.roman(number).get.asString()
  }
}


