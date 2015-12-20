package frdomain.e2e

import scala.concurrent.Future

import scalaz._
import Scalaz._

import org.joda.time._

package object domain {
  type Error = String
  type Amount = BigDecimal
  def today = DateTime.now()
  type ErrorOr[+A] = String \/ A

  final val ZERO = BigDecimal(0)

  def dateEquals(d1: DateTime, d2: DateTime) = 
    d1.toLocalDate.compareTo(d2.toLocalDate) == 0

  object Joda {
    implicit def dateTimeOrdering: scala.math.Ordering[DateTime] = scala.math.Ordering.fromLessThan(_ isBefore _)
    val f = (d1: LocalDate, d2: LocalDate) => d1.compareTo(d2) < 0
    implicit def localDateOrdering: scala.math.Ordering[LocalDate] = scala.math.Ordering.fromLessThan(f)
  }
}



