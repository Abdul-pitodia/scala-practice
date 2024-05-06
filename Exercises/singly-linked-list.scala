abstract class MyList {
  def head: Int
  def tail: MyList

  def isEmpty: Boolean
  def addElement(x: Int): MyList

  def printElements: String
  // below is a polymorphic call, which will delegate to proper printElements implementation
  override def toString: String = "[" + printElements + "]"
}

object EmptyList extends MyList {
  def head = throw new NoSuchElementException
  def tail = throw new NoSuchElementException

  def isEmpty = true
  def addElement(x: Int) = new ConsList(x, EmptyList)
  def printElements = "Empty"
}

class ConsList(h: Int, t: MyList) extends MyList {

  def head = h
  def tail = t

  def isEmpty = false
  def addElement(x: Int) = new ConsList(x, this)
  def printElements = s"$head -> ${tail.printElements}"

}

val obj = new ConsList(1, new ConsList(2, new ConsList(3, EmptyList)))
println(s"Address of tail on main list ${obj.tail}")
println(s"Address of main list ${obj}")
val modified = obj.tail.addElement(5)
println(s"Address of modified tail ${modified}")

// 5 -> 2 -> 3
modified.printElements

// 1 -> 2 -> 3
obj.printElements

// println(modified.tail.head)
// modified.printElements