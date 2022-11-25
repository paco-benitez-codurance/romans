package roman.mapper

import cats._
import cats.data._
import cats.implicits._

import roman._
import roman.given

class BasicMapping(numberOfRomans: Int) extends MapRoman {

  def findBasicMultipliedBy(mult: Int)(number: Int): Option[Roman] =
    BasicTypes.reverse
      .find(_._1 * mult == number)
      .map(x => Roman(x._2))

  override def roman(number: Int): Option[Roman] =
    findBasicMultipliedBy(numberOfRomans)(number).map(rom =>
      Semigroup.combineN(rom, numberOfRomans)
    )
}
