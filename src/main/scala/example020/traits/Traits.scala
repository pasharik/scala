package example020.traits

trait Motorbike {
  val brand: String
}

trait Shiny {
  val shineFactor: Int
}

class HondaBros extends Motorbike with Shiny {
  override val brand: String = "Honda"
  override val shineFactor: Int = 100500
}

object Traits extends App {
  val bike = new HondaBros()
  println(bike.brand + " " + bike.shineFactor)
}
