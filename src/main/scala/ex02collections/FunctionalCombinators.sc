def timesTwo(i: Int): Int = i * 2
def isEven(i: Int): Boolean = i % 2 == 0

//map
val numbers = List(1, 2, 3, 4)
numbers.map((i: Int) => i * 2)    //List(2, 4, 6, ...)
numbers.map(timesTwo)    //Compiler converts method to a function

//foreach
numbers.foreach((i: Int) => println(i))   //Returns nothing - Unit

//filter
numbers.filter((i: Int) => i % 2 == 0)   //List(2, 4)
numbers.filter(isEven)

//zip
List(1, 2, 3).zip(List("a", "b", "c")) //List((1,a), (2,b)...)
  .foreach((p: (Int, String)) => println(p._1))

//partition
val numbers2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
numbers2.partition(_ % 2 == 0)  // (List[Int], List[Int])

//find
numbers2.find(_ > 5)  //Option[Int] = Some(6)

//drop
numbers2.drop(5)  //Drop first 5

//dropWhile
numbers2.dropWhile(_ < 7)  //List(7, 8, 9, 10)

//foldLeft
//0 - initial value
//m - accumulator
//n - next value
numbers2.foldLeft(0)((m: Int, n: Int) => m + n)

//foldRight
numbers2.foldRight(0) { (n: Int, m: Int) =>
  println("m: " + m + " n: " + n)
  m + n
}

//flatten
val nestedNumbers = List(List(1, 2), List(3, 4))
nestedNumbers.flatten  //List(1, 2, 3, 4)

//flatMap
nestedNumbers.flatMap(_.map(_ * 2))  //List(2, 4, 6, 8)
//nestedNumbers.flatMap(x => x.map(_ * 2))
//nestedNumbers.flatMap((x: List[Int]) => x.map(_ * 2))


//Define our own function
//Every function can be defined using fold
def ourFun(x: List[Int], fn: Int => Int): List[Int] = {
  x.foldRight(List[Int]()){ (i, res) =>
    fn(i) :: res
  }
}
ourFun(numbers2, timesTwo(_))

//filter - on map. Map - list of tuples
val m = Map("100" -> 100, "200" -> 200, "300" -> 300)
//m.filter((p: (String, Int)) => p._2 > 100)
//m.filter(_._2 > 100)
m.filter({case (key, value) => value > 100}) //Partial pattern match