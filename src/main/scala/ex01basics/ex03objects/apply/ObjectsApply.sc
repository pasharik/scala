object Foo {
  def apply() = println("Hello")
}
Foo()

class Bar {
    def apply() = println("Hello, Bar!")
}
val b = new Bar()
b()
//Or just: new Bar()()

