package example010.classes

class Calculator {
  val color = "White"
}

class Calculator2(brand: String) {
  val color: String =
    if (brand == "HP") "Black"
    else "White"

  def add(m: Int, n: Int): Int = m + n
}

object Classes extends App {
  val c = new Calculator
  println(c.color)

  val c2 = new Calculator2("HP")
  println(c2.color + " " + c2.add(1, 2))
}
