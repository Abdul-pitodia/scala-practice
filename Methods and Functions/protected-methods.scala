class Animal {
  private def breathe() = println("I’m breathing")
  def walk() = {
    breathe()
    println("I’m walking")
  }
  protected def speak() = println("Hello?")
}

class Cat extends Animal {
  override def speak() = println("Meow")
}

val cat = new Cat
cat.walk()
cat.speak()
cat.breathe()   // won’t compile because it’s private