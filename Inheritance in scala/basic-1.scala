class Animal {
  def eat() = println(s"I eat")
  protected def walk() = println(s"I walk..")
}

class Cat extends Animal

val cat = new Cat
cat.eat()

// not accessible, only accessible within Cat class scope as method is protected
cat.walk()