class Animal{
  def eat() = s"nom nom"
  val overrideThisValue = 2
}

class Cat extends Animal {
  override def eat() = s"meow nom nom"
  override val overrideThisValue = 5
  def purr() = s"Cat meows"
}

class Dog extends Animal {
  override def eat() = {
    println(super.eat())
    println(s"Bark nom nom")
    ""
  }
}

val obj: Animal = new Cat
// fails to compile
// due to compile time polymorphism
// obj.eat()

val dog: Animal = new Dog
// prints 
// nom nom
// Bark nom nom
dog.eat()

