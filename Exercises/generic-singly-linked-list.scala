trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(el: A): B
}

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]

  def isEmpty: Boolean
  def addElement[B >: A](x: B): MyList[B]

  def printElements: String
  // below is a polymorphic call, which will delegate to proper printElements implementation
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A,MyList[B]]): MyList[B]
}

object EmptyList extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty = true
  def addElement[B >: Nothing](x: B): MyList[B] = new ConsList(x, EmptyList)
  def printElements = "Empty"
  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = EmptyList
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = EmptyList

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = EmptyList

}

class ConsList[+A](h: A, t: MyList[A]) extends MyList[A] {

  def head: A = h
  def tail: MyList[A] = t

  def isEmpty = false
  def addElement[B >: A](x: B): MyList[B] = new ConsList(x, this)
  def printElements = s"$head -> ${tail.printElements}"

  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new ConsList(transformer.transform(head), tail.map(transformer))
  }

  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(head)) new ConsList(head, tail.filter(predicate))
    else tail.filter(predicate)
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = new ConsList(head, tail ++ list)
  
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(head) ++ tail.flatMap(transformer)
  }

}

val listOfIntegers: MyList[Int] =
  new ConsList[Int](1, new ConsList(2, EmptyList))
listOfIntegers.printElements

val listOfString: MyList[String] = new ConsList("1",new ConsList("2", new ConsList("3", EmptyList)))
val listConverted = listOfString.map(new MyTransformer[String, Int] {
  override def transform(el: String): Int = el.toInt * 2
})

listConverted.printElements

listConverted.filter(new MyPredicate[Int] {
  override def test(el: Int): Boolean = el%2 == 1
}).printElements


listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
  override def transform(el: Int): MyList[Int] = new ConsList(el, new ConsList(el+1, EmptyList))
}).printElements