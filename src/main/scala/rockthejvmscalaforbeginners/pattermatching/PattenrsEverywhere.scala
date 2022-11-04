package rockthejvmscalaforbeginners.pattermatching

object PattenrsEverywhere extends App {

  /** los catch de una excepcion son matchs
    */
  /*
  try {} catch {
    case e: RuntimeException   => "RuntimeException"
    case f: StackOverflowError => "StackOverflowError"
  }*/

  /** todos los generadores se basan en la coincidencia de patrones
    */
  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (f, s) <- tuples
  } yield f * s

  /** multiple valores definidos basados en pattern matchin
    */

  val tuple = (1, 2, 39)
  val (a, t, v) = tuple
  println(t)

  val lsit = List(1, 2, 39)
  val head :: tail = lsit
  println(head)
  println(tail)

  /** funciones parciales basadas en pattenrs matching
    */

  val mappedList = lsit.map {
    case v if v % 2 == 0 => v + "   is even"
    case 1               => "uno"
    case _               => "lo que sea"
  }

  val mappedList2 = lsit.map { x =>
    x match {
      case v if v % 2 == 0 => v + "   is even"
      case 1               => "uno"
      case _               => "lo que sea"
    }
  }

}
