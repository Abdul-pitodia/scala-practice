////////////----------------------------/////////////////

abstract class Animal {
  val creatureType: String
  def eat: Unit
}

// Animal is abstract; it cannot be instantiated
val animal: Animal = new Animal

////////////----------------------------/////////////////

abstract class Animal {
  // provide abstract definitions
  // can also provide common definitions
  val creatureType: String
  def eat: Unit
}

class Dog extends Animal {
  val creatureType = "Dog"
  def eat = println("Dog eats..")
}

val obj: Animal = new Dog
// prints -> Dog eats...
obj.eat

////////////----------------------------/////////////////

abstract class Animal {
  val creatureType: String
  def eat(): Unit
}

class Dog extends Animal {
  val creatureType = "Dog"
  def eat() = println("Dog eats..")
}

trait Carnivore {
  def eat(animal: Animal): Unit
}

class Crocodile extends Animal with Carnivore {
  val creatureType = "Crocodile"
  def eat() = println(s"$creatureType eats..")
  def eat(animal: Animal) = println(s"I am a crocodile and i am eating animal of type ${animal.creatureType}")
}

val croc = new Crocodile
val dog: Animal = new Dog
// Crocodile eats..
croc.eat()

// I am a crocodile and i am eating animal of type Dog
croc.eat(dog)


////////////----------------------------/////////////////

// Difference between abstract classes and traits
// -> traits do not have constructor (possible in Scala-3)
// -> traits define behavior, however abstract classes define a blueprint itself, for e.g. Animal, but trait is Carnivore, etc
// -> Multiple inheritance is supported by traits, because two conflicting methods when overriden in the implementing class 
// -> Diamond problem is solved by writing an implementation on the implementing class 
// -> in case of multiple inheritance in classes, the subclass will get confused which implementation to choose, if method not overriden

