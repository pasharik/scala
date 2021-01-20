def calcX(): Int = {
  println("Getting x...")
  2
}

//Call by name. So `x` evaluated every time, it's used in function belo
//Hence calcX() called twice
def squareByName(x: => Int) =
  x * x

squareByName(calcX())