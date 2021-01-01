package coursera.week1

import java.util.NoSuchElementException

object Lists {

  def sum(xs: List[Int]): Int = if (xs.isEmpty) 0 else xs.head + sum(xs.tail)

  /**
   * @throws java.util.NoSuchElementException if `xs` is an empty list
   */
  def max(xs: List[Int]): Int =
    if (xs.isEmpty) throw new NoSuchElementException() else
      maxR(xs.head, xs.tail)

  def maxR(a: Int, xs: List[Int]): Int =
    if (xs.isEmpty) a else
      Math.max(a, maxR(xs.head, xs.tail))

}
