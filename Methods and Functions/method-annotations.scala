class Person(fname: String){
  // all operators are methods
  def +(lname: String) = s"$fname $lname"

  // works with ! + - ` (like -1, !var)
  def unary_! : String = s"$fname unary !!!"

  // can invoke as postfix , with just braces()
  def apply(): String = s"Apply invoked"

  // works with methods only having one argument
  def infixNotation(test: String) = s"testing infix notation $test"
}

val x = new Person("Abdul")
println(x + "Pitodia")
println(!x)
println(x())
println(x infixNotation "passes..")

