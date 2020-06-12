val times = 1
val str = times match {
  case 1 => "One"
  case 2 => "Two"
  case _ => "Unknown"
}
println(str)

//matching with guard - extra condition
val num = 100
val numStr = num match {
  case i if (i < 10) => "Small"    //Capture 'num' in 'i'
  case i if (i < 200) => "Medium"  //Can use the same variable name - 'i' or another
  case _ => "Unknown"
}
println(numStr)

//matching on type
def bigger(o: Any): Any =
  o match {
    //best practice - call variable as first letter of type
    case i: Int if (i < 0) => i - 1
    case i: Int => i + 1
    case d: Double if (d < 0) => d - 0.1
    case d: Double => d + 0.1
    case text: String => text + "s"
  }
println(bigger(1))
println(bigger(1.0))
println(bigger(-1))
println(bigger(-0.3))
println(bigger("Some text "))
