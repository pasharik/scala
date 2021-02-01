import scala.annotation.tailrec

//Left
//Fold can handle empty lists - it will return zero element 'z'
@tailrec
def foldLeft[U, T](z: U)(list: List[T], op: (U, T) => U): U = list match {
  case Nil => z
  case x :: xs => foldLeft(op(z, x))(xs, op)
}
def reduceLeft[T](list: List[T], op: (T, T) => T): T = list match {
  case Nil => throw new Error("Nil.reduceLeft")
  case x :: xs => foldLeft(x)(xs, op)
}
//Right
def reduceRight[T](list: List[T], op: (T, T) => T): T = list match {
  case Nil => throw new Error("Nil.reduceLeft")
  case x :: Nil => x
  case x :: xs => op(x, reduceRight(xs, op))
}
def foldRight[U, T](z: U)(list: List[T], op: (T, U) => U): U = list match {
  case Nil => z
  case x :: xs => op(x, foldRight(z)(xs, op))
}

//DIY
def mapFunMy[T, U](xs: List[T], f: T => U): List[U] =
  foldRight(List[U]())(xs, (a: T, b: List[U]) => f(a) :: b )

//Standard scala List.foldRight
def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())( (a: T, l: List[U]) => f(a) :: l )

//Testing
val l = List(1, 2, 3, 4)
foldLeft(0)(l, (a, b: Int) => a + b) //sum
foldLeft(1)(l, (a, b: Int) => a * b) //product

foldRight(0)(l, (a: Int, b) => a + b) //sum
reduceRight[Int](l, (a, b) => a + b)  //sum

mapFun(l, (a: Int) => a * 2)
mapFunMy(l, (a: Int) => a * 2)