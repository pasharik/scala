//Option
//`Some` and `None` are subclasses of Option
val m = Map(1 -> "One", 2 -> "Two")
val someRes = m.get(1)     // Option[String] = Some("One")
val noneRes = m.get(3)     // None

someRes.get     //String
//noneRes.get     //Exception :(

//Proper way
someRes.getOrElse("abc").toUpperCase   //'ONE'
noneRes.getOrElse("abc").toUpperCase   //'ABC'

//Match
val result = noneRes match {
  case Some(s) => s.toLowerCase
  case None => "empty:("
}
