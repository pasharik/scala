abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  //See persistent_data_structure.png
  //Old root still remains, but we create new structure path
  // - good for parallelism
  override def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  override def union(other: IntSet) =
    ((left union right) union other) incl elem

  override def toString = s"{$left$elem$right}"
}

//object instead of class - single instance, save memory
object Empty extends IntSet {
  override def incl(x: Int) = new NonEmpty(x, Empty, Empty)

  override def contains(x: Int) = false

  override def union(other: IntSet) = other

  override def toString = "."
}

///////////
val t1 = new NonEmpty(3, Empty, Empty)
val t2 = t1 incl 4