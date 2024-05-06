abstract class Test {
  def eat = "Eating.."
}

val x = new Test {
  override def eat = "overriden the eat method"
}

// prints -> overriden the eat method
println(x.eat)

////////////----------------------------/////////////////

class Person(val name: String){
  def sayHi = s"My name is $name"
}

val abdul = new Person("Abdul") {
  override def sayHi = s"My name is $name pitodia"
}

// prints -> My name is Abdul pitodia
abdul.sayHi

////////////-------------------------------------------------------------------------/////////////////

trait Poison {
  def color: String
}

abstract class Snake {
  def snakeType: String
}

val viper = new Snake with Poison {
  override def color = "green"
  override def snakeType = "viper"
}

viper.color
viper.snakeType