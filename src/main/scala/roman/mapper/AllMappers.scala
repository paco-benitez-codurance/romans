package roman.mapper

import cats._
import cats.data._
import cats.implicits._

import roman.model._
import roman.model.given

trait AllMappers {

  val allMappers =
    Seq(
      BasicMapping(1),
      BasicMapping(2),
      BasicMapping(3),
      AddToRight(1),
      AddToRight(2),
      AddToRight(3),
      AddOneToLeft(),
      CombinationOne()
    ).reduce(_ |+| _)

}
