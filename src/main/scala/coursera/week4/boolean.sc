abstract class Boolean2 {
  def ifThenElse[T](t: => T, e: => T): T

  def &&(x: => Boolean2): Boolean2 = ifThenElse(x, False2)

  def ||(x: => Boolean2): Boolean2 = ifThenElse(True2, x)

  def unary_! : Boolean2 = ifThenElse(False2, True2)

  def ==(x: => Boolean2): Boolean2 = ifThenElse(x, x.unary_!)

  def !=(x: => Boolean2): Boolean2 = ifThenElse(x.unary_!, x)

  //false < true
  def <(x: => Boolean2): Boolean2 = ifThenElse(False2, x)
}

object False2 extends Boolean2 {
  override def ifThenElse[T](t: => T, e: => T) = e
}

object True2 extends Boolean2 {
  override def ifThenElse[T](t: => T, e: => T) = t
}
