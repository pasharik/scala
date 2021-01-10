def sum(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, f(a) + acc)
  }
  loop(a, 0)
}

sum(x => x, 1, 3) //anonymous function
sum(x => x * x * x, 1, 3)

def cube(x: Int) = x * x * x
sum(cube, 1, 3) //function by name
