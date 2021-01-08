package coursera.week1.assignment

import scala.annotation.tailrec

object RecFun {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }

    println(balance("(just an) example".toList))

    println(countChange(4, List(1, 2)))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c <= 0 || c >= r) 1 else
      pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def balanceRecur(ch: Char, remainingChars: List[Char], count: Int): Boolean = {
      val cnt: Int =
        if (ch == '(') count + 1
        else if (ch == ')') count - 1
        else count

      if (cnt < 0) false
      else if (remainingChars.isEmpty) cnt == 0
      else balanceRecur(remainingChars.head, remainingChars.tail, cnt)
    }

    if (chars.isEmpty) true
    else balanceRecur(chars.head, chars.tail, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def loop(money: Int, coin: Int, coins: List[Int]): Int = {
      def curResult() =
        if (money <= 0) 0
        else if (money == coin) 1
        else
          loop(money - coin, coin, coins)

      def otherResult() =
        if (coins.isEmpty) 0
        else
          loop(money, coins.head, coins.tail)

      curResult() + otherResult()
    }

    if (coins.isEmpty) 0
    else
      loop(money, coins.head, coins.tail)
  }

}
