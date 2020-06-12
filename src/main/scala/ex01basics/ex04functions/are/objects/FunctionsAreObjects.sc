object addOne extends Function1[Int, Int] {
  override def apply(i: Int) = i + 1
}
println(addOne(1))

//syntactic sugar
class TimesTwo extends (Int => Int) {
  override def apply(i: Int) = i * 2
}
val multiByTwo = new TimesTwo()
println(multiByTwo(4))

