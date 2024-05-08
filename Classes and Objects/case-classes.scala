case class Person(name: String, age: Int)

val jim1 = Person("jim",23)
val jim2 = Person("jim",23)

// auto generated hashcode and equals
println(jim1 == jim2)

// parameters are fields
println(jim1.name)

// toString method
println(jim1.toString())

// copy method
println(jim1.copy(age = 52).toString())

// by default apply methods on companion objects
val p = Person("Abdul",24)

// enables pattern matching, are serializable

case object Animal{
}

