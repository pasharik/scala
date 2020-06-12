//Same as data classes in Kotlin?
case class Calculator(brand: String, model: String)
val hp20b = Calculator("HP", "20B") //No 'new' required - case class has 'apply' method inside
val hp20B = Calculator("HP", "20B")
val hp30B = Calculator("HP", "30B")

println(hp20b == hp20B) //true

def calcType(calc: Calculator) = calc match {
  case Calculator("HP", "20B") => "Financial"
  case Calculator("HP", "30B") => "Business"
  case Calculator(someBrand, someModel) => s"Calculator $someBrand $someModel is of unknown type"
  //case c@Calculator(_, _) => s"Calculator is unknown: $c" // re-bind to another variable name
  //case Calculator(_, _) => "Unknown calc"
  //case _ => "Unknown calc"
}

println(calcType(hp20b))
println(calcType(hp30B))
println(calcType(Calculator("Xiaomi", "SuperCalc")))
