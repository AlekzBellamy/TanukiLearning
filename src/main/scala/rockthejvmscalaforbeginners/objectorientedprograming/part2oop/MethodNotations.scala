package rockthejvmscalaforbeginners.objectorientedprograming.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def movieLikes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String =
      s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String =
      hangOutWith(person)

    def unary_! : String = "mm=?"

    def isAlive: Boolean = true

    def apply(): String = s"Hello $name"
  }
  // Notacion Infija - Notacion operador / Azucar Sintactiva(Syntatic sugar)/ infix
  val alekz = new Person("alekz", "el origen")
  println(alekz.movieLikes("el origen"))
  println(
    alekz movieLikes "el origen"
  ) // Notacion Infija/ Notacion Operador se omiten los puntos y ()

  val tom = new Person("Tom", "los supersonicos")
  // Uhna caracteristica de esta notacion de tipo operador, esque parece un operador matematico
  println(alekz hangOutWith tom)

  // como scala es premisivo el nombre del metodo hangOutWith puede ser solo un +
  println(alekz + tom)
  println(alekz.+(tom))
  // y ademas pueden actual com olos operadores matematicos

  // NOTAA/ CONCLUSION TODOS LOS OPERADORES SON METODOS

  /// Notacion Prefija / prefix
  // son operadores unarios --> unary_ ?????
  // son metodos con subrayado urinario con prefijo

  // ambos son equivalente
  val x = -1
  val y = 1.unary_-
  // el prefijo unary:  solo trabaja con - +  ! ~

  //
  println(!alekz)
  println(alekz.unary_!)

  /// Notacion postfija / ṕostfix
  // aquellas funciones alas que no se le pasen parametros , tienen la propiedad de que pueden usarse en notacion postfija

  println(alekz.isAlive)
  println(alekz isAlive) // se requiere postfixOps D=

  //APPLY  lo que caracteriza esta notacion es el firmado/ nombre del metodo, si o si es apply()
  println(alekz.apply())
  println(
    alekz()
  ) // permite citar a la instancia como si fuera una funcion y eso se debe aque  se deifnio apply
}
