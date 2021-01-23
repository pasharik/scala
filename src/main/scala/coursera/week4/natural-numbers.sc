import scala.annotation.tailrec
//Peano numbers

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  override def isZero = true

  override def predecessor = throw new IllegalArgumentException

  override def +(that: Nat) = that

  override def -(that: Nat) = if (that.isZero) this else throw new IllegalArgumentException
}

class Succ(n: Nat) extends Nat {
  override def isZero = false

  override def predecessor = n

  //Not tail-recursive?
  override def +(that: Nat): Nat =
    new Succ(n + that)
//    plusAcc(that, this)

//  @tailrec
//  private def plusAcc(that: Nat, acc: Nat): Nat =
//    if (that.isZero) acc
//    else plusAcc(that.predecessor, acc.successor)

  override def -(that: Nat) =
    if (that.isZero) this
    else n - that.predecessor
  //    minusAcc(that, this)

//  @tailrec
//  private def minusAcc(that: Nat, acc: Nat): Nat =
//    if (that.isZero) acc
//    else minusAcc(that.predecessor, acc.predecessor)
}