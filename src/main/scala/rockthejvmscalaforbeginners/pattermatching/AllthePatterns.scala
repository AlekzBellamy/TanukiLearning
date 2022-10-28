package rockthejvmscalaforbeginners.pattermatching

object AllthePatterns extends App {

  /** se puede usar el patron de coincidencia a constantes
    */

  val x: Any = "Scala"
  val constant = x match {
    case 1              => "es 1"
    case "Scala"        => "The Scala"
    case true           => "true"
    case AllthePatterns => "Asingleton object"
    case _              => ""
  }

  /** el wildcarg o _ underscore, no  es un comodin pero coincide con cualquier cosa e n una implemnetacioncion
    */

  val loquesea = x match {
    case _ => "loque sea"
  }

  /** coincidencia de variable
    */

  val matchAVariable = x match {
    case something =>
      s" usamos la propiedad ${something}" // se puede nombrar la propiedad y usarlño en la expresion
  }

  /** coinciencia en tuplas ñ,ñ
    */
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) => // podemos pasar literalmente la tupla
    case (something, 2) =>
      s" usamos la propiedad ${something}" // podemos pasar  una tupla de ppatrones anidados
  }

  /** para tuplas anidadas tambien funciona
    */
  val aTuple2 = (1, (2, 3))
  val matchATuple2 = aTuple2 match {
    case (_, (1, v)) =>
      s"  propiedad ${v}" // podemos pasar literalmente la tupla
    case (1, something) =>
      s" usamos la propiedad ${something._1}  y ${something._2}" // podemos pasar  una tupla de ppatrones anidados
  }

  /** se piede usar para case clases (constructor pattenrs)
    */
}
