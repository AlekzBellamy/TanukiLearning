package rockthejvmscalaforbeginners.objectorientedprograming.exercises

abstract class MyList0[+A] {
  def head: A

  def tail: MyList0[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList0[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"
}

object EmptyList0 extends MyList0[Nothing] {
  def head: Nothing = throw new NoSuchElementException()

  def tail: MyList0[Nothing] = throw new NoSuchElementException()

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList0[B] =
    new ConsList0(element, EmptyList0)

  def printElements: String = ""
}

class ConsList0[+A](h: A, t: MyList0[A]) extends MyList0[A] {
  def head: A = h

  def tail: MyList0[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList0[B] = new ConsList0(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else "" + h + t.printElements + ""
}
object test0 extends App {

  val myList0: MyList0[Int] =
    new ConsList0[Int](
      1,
      new ConsList0[Int](2, new ConsList0[Int](3, EmptyList0))
    )
  val myList1: MyList0[String] = new ConsList0[String](
    "hola",
    new ConsList0[String]("alekz", new ConsList0[String]("hola", EmptyList0))
  )

  println(myList0.printElements)
  println(myList1.printElements)
}
