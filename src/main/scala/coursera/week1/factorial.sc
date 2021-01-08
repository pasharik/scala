import scala.annotation.tailrec

//NOT tail-recursive - uses stack
// x * factor(...) - after returning from inner call, we need to
// perform some other action
def factorialNonTail(x: Int): Int =
  if (x == 0) 1 else x * factorialNonTail(x - 1)

//Tail-recursive. facRecur(...) is last statement
//compiler optimizes it to run in a loop instead of stack
def factorial(x: Int): Int = {
  @tailrec
  def facRecur(n: Int, x: Int): Int =
    if (x == 0) n else facRecur(n * x, x - 1)

  facRecur(1, x)
}

factorial(4)
