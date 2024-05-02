case class Person(name: String, age: Int)

object Person {
  def apply(name: String, age: Int) = {
    val capitalName = 
      if (!name.isEmpty){
        val fch = name.charAt(0).toUpper
        val restName = name.substring(1)
        s"$fch$restName"
      }
      else {
        throw new IllegalArgumentException("Name is empty..")
      }
    new Person(capitalName, age)  
  }
}

val x = Person("sally",28)
println(x)