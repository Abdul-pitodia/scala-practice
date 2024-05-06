////////////----------------------------/////////////////

class Animal {
  final def eat() = println(s"eating")
}

class Dog extends Animal {
  // error overriding method eat in class Animal of type (): Unit;
  // method eat of type (): Unit cannot override final member method eat in class Animal
  override def eat() = println(s"I cant override this")
}

////////////----------------------------/////////////////

final class Animal {
  final def eat() = println(s"eating")
}

// class Dog cannot extend final class Animal
class Dog extends Animal {
  def eat() = println(s"I cant override this")
}

////////////----------------------------/////////////////

sealed class Animal {
  final def eat() = println(s"eating")
}

// can only extend classes in the same file, not other packages
class Dog extends Animal {
}