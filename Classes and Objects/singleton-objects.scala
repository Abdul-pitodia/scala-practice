object Person {
  val x = 2
  private var p_var_of_obj = "I am private string of object Person"
}

class Person {
  private var p_var_of_class = "I am private string of class Person"
  def check = println(s"${Person.p_var_of_obj} (object variable accessible from class def scope")
}

val p1 = Person
val p2 = Person

// prints true, because object is a singleton
println(p1 == p2)

val p3 = new Person
// prints -> I am private string of object Person (object variable accessible from class def scope
println(p3.check)