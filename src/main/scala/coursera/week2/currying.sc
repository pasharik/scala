//return type: (Int => Int) => ((Int, Int) => Int)
def sum(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum(f)(a + 1, b)

sum(x => x)(1, 3)

def sumOfSquares = sum(x => x * x) _
sumOfSquares(1, 3)


//Product
def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1 else f(a) * product(f)(a + 1, b)

product(x => x)(1, 4)


//Factorial
def fact(n: Int) = product(x => x)(1, n)

fact(5)


//Combine sum and product. Kind of map-reduce. f - mapping; operation - reduce
def mapReduce(f: Int => Int, operation: (Int, Int) => Int, zeroValue: Int)
             (a: Int, b: Int): Int =
  if (a > b) zeroValue else operation(f(a), mapReduce(f, operation, zeroValue)(a + 1, b))

def productByMapReduce(a: Int, b: Int): Int = mapReduce(x => x, (x, y) => x * y, 1)(a, b)
productByMapReduce(1, 4)

def sumByMapReduce = mapReduce(x => x, (x, y) => x + y, 0)_
sumByMapReduce(1, 3)

mapReduce(x => x, (x, y) => x + y, 0)(1, 3) //sum
mapReduce(x => x, (x, y) => x * y, 1)(1, 4) //product

