class Animal {
// private method cannot be overriden nor be accessed by instances
  private def breathe() = println("I am breathing")
}


class Dog extends Animal {
  override def breathe() = println("Overriding this results in error..")
}

val x : Animal = new Dog
// does not compile
x.breathe()