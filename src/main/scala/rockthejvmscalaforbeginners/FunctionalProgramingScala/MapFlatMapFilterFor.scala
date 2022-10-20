package rockthejvmscalaforbeginners.FunctionalProgramingScala

object MapFlatMapFilterFor extends App {

  /** usos de  map flat map filter y for
    */

  val list = List(1, 2, 3)
  println(list.head)
  println(list.tail)
  println(list.map(_ + 1))
  println(list.map(_ + "$ numero"))

  println(list.filter(_ % 2 == 0))

  val toPair =
    (x: Int) =>
      List(
        x,
        x + 1
      ) // una funcion que mete a x en una lista  similar a una tupla para que se asginar su valor y el siguiente numero el mismo +1

  println(list.flatMap(toPair))
  val numbers = List(1, 2, 3, 4, 5)
  val chars = List('a', 'b', 'c')

  println(chars.map { c =>
    numbers.map(c.toString + _)
  }) //???? si le hago un flaten mehjor uso un map lml

  println(chars.flatMap { c => numbers.map(c.toString + _) })

  val colors = List("black", "withe")
  println(chars.flatMap { c =>
    numbers.flatMap(n => colors.map(n.toString + c + _))
  })

  /** for compresions.. este for lo  ehvisto que resuelve  funciones del mismo tipo , en este caso son listas
    */
  val forCombinations = for {
    n <- numbers if n % 2 == 0 // se pueden aplicar  o usar guardias
    c <- chars
    color <- colors
  } yield (n.toString + c + color)

  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  /**
   * NOTA, los valores  opciondales son importantesssss!!!
   */
}
