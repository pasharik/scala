trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
  }
}

case class Number(n: Int) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr

def show(e: Expr): String = e match {
  case Number(n) => s"$n"
  case Sum(e1, e2) => s"(${show(e1)})+(${show(e2)})"
}

//Testing
val e = Sum(Sum(Number(1), Number(2)), Number(3))
show(e)