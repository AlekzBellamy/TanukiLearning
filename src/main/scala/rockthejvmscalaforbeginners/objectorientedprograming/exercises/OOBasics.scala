package rockthejvmscalaforbeginners.objectorientedprograming.exercises

/** Exercises,
  * 1. implementar una Novela y una clase de escritores, una novela significa un libro
  * Writer -y un escritor es el que las esqcribe
  * El escritor  tendrea el primer nombrre y un apellido, y el año de nacimiento
  * Metodo de nombre completo que devuelve la concatenacion de nombre y apellido
  *  NOVEL - la novela tendria  un nombre de curso y año de lanzamiento y un autor, instancia de escritor
  *  Los metodos seran ,  una uqe obtenga la edad , otro metodo que seria escrito por autor
  *  un metodo  llamado copy (nyevo año de liberacion ), que sera una instancia de novela con el nuevo año de lanzamiento
  *
  *  2. crear un apequeña clase contadora que tenga
  *  un campo que devuelva un valor entero COUNTER
  *  un metodo que devuelve el conteo actual
  *  un metodo para incrementar o disminuir el contador a 1 que retorna un new COUNTER
  *  un metodo  de sobrecarga que recive un monto
  */
object OOBasics extends App {

  val author = new Writer("alekz", "medina", 1982)
  val author0 = new Writer("alekz", "medina", 1982)
  val novel = new Novel("great Exprectations", 1995, author)

  println(novel.authorAge())
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(author0))

  val counter = new Counter()
  counter.print()
  counter.counterIncrement().print()
  counter
    .counterIncrement()
    .counterIncrement()
    .counterIncrement()
    .counterIncrement()
    .counterIncrement()
    .print()
  counter.print()
  counter.counterIncrement(10).print()
}

class Writer(name: String, surname: String, val year: Int) {
  def fullName(): String = s"Full Name: $name $surname"
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge(): String = s" Age: ${year - author.year}"
  def isWrittenBy(author: Writer): Boolean = this.author == author

  def copy(newYearRelease: Int): Novel =
    Novel(name = this.name, author = this.author, year = newYearRelease)

}

class Counter(val count: Int = 0) {
  def current(): Int =
    count //--> se omite si colocamos la palabra clave val  y omitimos este metodo, lo cumplee :P
  def counterIncrement(): Counter = {
    println("increment")
    new Counter(count + 1)
  } // inmutabilidad ->no modificamos count, creamos uno nuevo
  def counterDecrement(): Counter = {
    println("Decrement")
    new Counter(count - 1)
  }

  def counterIncrement(n: Int): Counter = {
    if (n <= 0) this
    else counterIncrement().counterIncrement(n - 1)
  }

  def counterDecrement(n: Int): Counter = {
    if (n <= 0) this
    else counterDecrement().counterDecrement(n - 1)
  }

  def print() = println(count)
}
