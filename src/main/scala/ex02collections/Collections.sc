//Arrays are mutable
val numbersArr: Array[Int] = Array(1, 2, 3, 1)
numbersArr(3) = 100500
println(numbersArr(3))

//Lists are immutable
val numbersList: List[Int] = List(1, 2, 3, 1)
println(numbersList(3))

//Set are immutable
val numbersSet = Set(1, 2, 3, 1)
println(numbersSet)


//Tuple
val hostPort: (String, Int) = ("localhost", 80)
println(hostPort._1)
println(hostPort._2)
println(hostPort match {
  case ("localhost", port) => s"local: $port"
  case (host, port) => s"unknown: $host $port"
})
//Special syntax for tuple: a -> b
val numTuple: (Int, Int) = 1 -> 2


//Map - parameters just tuples
val m = Map(1 -> "One", (2, "Two"))
println(m(1))
val fMap = Map("printer" -> { println(_: Any) })
fMap("printer")("Hello!")
