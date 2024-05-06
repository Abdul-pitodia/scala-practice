abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]

  def isEmpty: Boolean
  def addElement[B >: A](x: B): MyList[B]

  def printElements: String
  // below is a polymorphic call, which will delegate to proper printElements implementation
  override def toString: String = "[" + printElements + "]"
}

object EmptyList extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty = true
  def addElement[B >: Nothing](x: B): MyList[B] = new ConsList(x, EmptyList)
  def printElements = "Empty"
}

class ConsList[+A](h: A, t: MyList[A]) extends MyList[A] {

  def head: A = h
  def tail: MyList[A] = t

  def isEmpty = false
  def addElement[B >: A](x: B): MyList[B] = new ConsList(x, this)
  def printElements = s"$head -> ${tail.printElements}"

}

val emptyListOfIntegers: MyList[Int] = EmptyList
val myListOfIntegers: MyList[Int] = new ConsList(1, new ConsList(2, EmptyList))
val myListOfStrings: MyList[String] = new ConsList("1", new ConsList("2", EmptyList))

println(myListOfIntegers)
println(myListOfStrings)