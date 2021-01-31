trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
  }
}

case class Number(n: Int) extends Expr

case class Var(name: String) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr

case class Prod(e1: Expr, e2: Expr) extends Expr

def show(e: Expr): String = e match {
  case Number(n) => s"$n"
  case Var(name) => s"$name"
  case Sum(e1, e2) => s"${show(e1)}+${show(e2)}"
  case Prod(l, r) => showInProd(l) + "*" + showInProd(r)
}

def showInProd(e: Expr): String = e match {
  case Sum(l, r) => s"(${show(l)}+${show(r)})"
  case _ => show(e)
}

//Testing
val e = Sum(Sum(Number(1), Number(2)), Var("x"))
val e2 = Prod(Sum(Number(1), Number(2)), Var("x"))
show(e)
show(e2)
show(Sum(Prod(Number(2), Var("x")), Var("y")))
show(Prod(Sum(Number(2), Var("x")), Var("y")))