package rockthejvmscalaforbeginners.objectorientedprograming.exercises

/** EJERCICIOS
  * Preindicaciones: es una lista enlzada simple, que contiene numeros enteros
  *  debe tener lo siguiente
  *  Encabezado/head -> ultimo  elemento agregado a la lista
  *  Cola / tail -> el resto de la lista
  *  un metodo isEMpty, para validar si la lista esta vacia
  *  un metodo add, para añadir un nuevo elemento y  debe generar una lueva lista new ..
  *  un mmetodo toString , que es lo que hay een la lista en String
  */
abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList

  def printElements: String

  /** Cmo en otros lenguajes , ls clases  tienen los  metodos toString y Equals  por lo cual se requiere sobreescribir
    * @return
    */
  override def toString: String = "[" + printElements + "]"
}

object EmptyList extends MyList {
  def head: Int = throw new NoSuchElementException()
  def tail: MyList = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new ConsList(element, EmptyList)

  def printElements: String = ""
}

class ConsList(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new ConsList(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object test extends App {
  val list = new ConsList(
    1,
    new ConsList(2, new ConsList(3, new ConsList(4, EmptyList)))
  )
  println(list.tail.head)
  println(list.add(5).head)

  println(list.isEmpty)

  println(list.printElements)
}
