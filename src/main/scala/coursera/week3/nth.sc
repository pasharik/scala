import coursera.week3._
import scala.annotation.tailrec

@tailrec
def nth[T](n: Int, xs: List[T]): T =
  if (n < 0 || xs.isEmpty) throw new IndexOutOfBoundsException(s"Index out of range: $n")
  else if (n == 0) xs.head
  else nth(n - 1, xs.tail)

val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

nth(2, list)