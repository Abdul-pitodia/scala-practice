class Person(name: String, age: Int) {
  def this(name: String) = this(name, 0)
}

class Adult(name: String, age: Int, gender: String) extends Person(name)

val adult: Person = new Adult("Abdul", 24, "Male")

