def intParse(s: String) =
  try {
    Integer.parseInt(s)
  } catch {
    case e: NumberFormatException => {
      println("Error while parsing number")
      0
    }
  } finally {
    //println("Do some cleaning...")
  }

println(intParse("123"))
println(intParse("abc"))
