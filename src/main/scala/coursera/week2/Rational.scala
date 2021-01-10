package coursera.week2

import scala.annotation.tailrec
import scala.math.abs

class Rational(x: Int, y: Int) {
  require(y != 0, "Denominator must not be zero")

  def this(x: Int) = this(x, 1)

  @tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  private val g = abs(gcd(x, y))

  def numer = x / g

  def denom = y / g

  def <(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < (that)) that else this

  def +(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def unary_- : Rational = new Rational(-numer, denom)

  def -(that: Rational) = this + (-that)

  override def toString = s"$numer/$denom"
}

object RationalStarter extends App {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  println(x)
  println(x < y)
  println(x + y)
  println(y - x)
  println(-x)
}
