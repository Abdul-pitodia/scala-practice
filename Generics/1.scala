class Animal

class Dog extends Animal
class Cat extends Animal

// upper bound , means cage only accepts sub-types of Animal
class Cage[A <: Animal](animal: A)

// lower bound, means cage only accepts super-types of Animal
class Cage2[A >: Animal](animal: A)

val cage = new Cage[Dog](new Dog)