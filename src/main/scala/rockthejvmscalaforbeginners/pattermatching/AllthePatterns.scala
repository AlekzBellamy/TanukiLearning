package rockthejvmscalaforbeginners.pattermatching

import rockthejvmscalaforbeginners.FunctionalProgramingScala.AnonymousFunctions
import rockthejvmscalaforbeginners.FunctionalProgramingScala.AnonymousFunctions.{
  ConsList,
  EmptyList,
  MyList
}

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

  /** se puede usar para case clases (constructor pattenrs)
    * la coincidencia de patrones tambo}ien se pueden anidar con clases de casos
    */

  val aList: MyList[Int] = ConsList(1, ConsList(2, EmptyList))

  val aMecthList = aList match {
    case ConsList(h, t)                    => ???
    case ConsList(h, ConsList(subh, subt)) => ???
    case AnonymousFunctions.EmptyList      => ???
    case _                                 => ???
  }

  /** lista patrones D=
    */

  val aStandarList = List(1, 2, 3, 64, 23)
  val aMatchList = aStandarList match {
    case List(1, _, _, _, _) =>
      ??? // este es avanzado debido a que se especifica que espera una lista con ese primer item
    case List(1, _*) =>
      ??? // _* que empiece con 1, pero _* detalla que es una lista de tamaño arbitrario
    case 1 :: List()             => ??? // añplicar el patron infijo
    case List(1, 2, 3, 64) :+ 23 => ??? // añplicar el patron infijo
    case ::(head, next)          => ???
    case Nil                     => ???
  }

  /** tipos especificaos
    */

  val desconocido: Any = 2
  val desconocidoMatch = desconocido match {
    case list: List[Int] => ???
    case dato: String    => ???
  }

  /** name binding- enlace por nombvre
    */

  val namebinding = aList match {
    case notEmptyList @ ConsList(_, _) => ???
    // nonEmptyList es un enlace de nombre , que te permite usar el nombre mas adelante o aqui en la expresion de retorno
    // pero el enlace de nombre es mas poderoso porque puede nnombrar patrones enteros
    case ConsList(h, rest @ ConsList(subh, subt)) => ???
    //  la llamda de nombre rest aplicaria para los anidados
    case AnonymousFunctions.EmptyList => ???
    case _                            => ???
  }

  /** multipatrones
    * son patrones encadenados
    */

  val multipatron = aList match {
    case EmptyList | ConsList(1, _) => ???
  }

  /** if guards
    */

  val otherSpecial = aList match {
    case ConsList(h, ConsList(subh, subt)) if subh % 2 == 0 => ???
  }

  /** }scala tiene un problema con el pattern matchin con los genericos
    * por lo cual solo lo ve como una suimple lista sin el tipo , por locual nos imprimira la primer opcion del tipo de lista
    * esto esta relacionado a JVM
    */

  val numbres = List(1, 2, 3, 4)

  val r = numbres match {
    case lsitaString: List[String] => "son string"
    case lsitaNumeros: List[Int]   => "son enteros"
    case _                         => "me"
  }
  val r2 = numbres match {
    case lsitaString: List  => "son string"
    case lsitaNumeros: List => "son enteros"
    case _                  => "me"
  }
  println(r)
}
