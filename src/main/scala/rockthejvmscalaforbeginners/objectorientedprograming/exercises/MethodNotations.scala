package rockthejvmscalaforbeginners.objectorientedprograming.exercises

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def movieLikes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String =
      s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String =
      hangOutWith(person)

    def unary_! : String = "mm=?"

    def isAlive: Boolean = true

    def apply(): String = s"Hello $name"

    def +(name: String): Person =
      new Person(s"${this.name} (${name})", favoriteMovie)

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def learns(param: String): String = s"$name learns ${param}"
    def learnsScala: String = learns("Scala")

    def apply(aux: Int): String = s"${name} watched Inception ${aux} times"
  }

  /** exercises
    * 1.- sobre cargar el metodo +, que reciba una cadena y que devuelva una  nueva persona con un apodo
    *    mary  + "the rockstar" => new person "mary (the rockstar)"
    * 2.- agregar  la edad a la clase persona con el valor 0 predeterminado   y agregue su operador unario  + , que basicamente aumenta el valor de la edad
    * y devuelva una persona nueva con la edad mas 1
    *    Add unary+ operator  => new person with the age +1
    *    + mary => mary with the age increment
    *  3.-  agregar un metodo learn en la clase person, que recibe como parametro un String y devulve
    *  una oracion mary learns Scala, ademas agregar un metodo  leansScala   que no reciba algun parametro  y llame  el metodo learns
    *  con "scala" como parametro y que se use en  postfix
    *
    *  4.- sobrecargar el metodo apply que reciba un numero yu devuelve una cadena
    *  mary.apply(2) ==> "MAry watched  Inception 2 times"
    */
  val alekz = new Person("alekz", "batman")
  val alekz0 = alekz + "tanuki"
  println(alekz0 name)
  println((alekz + "tanuki")()) // mandamos a llamar al apply definido
  println((alekz + "tanuki").apply())

  //println(alekz0.unary_+.age)
  val alekz1 = +alekz
  println(alekz1.age)
  println((+alekz).age)

  println(alekz.learns("Scala"))

  println(alekz learnsScala)

  println(alekz.apply(5))
  println(alekz(5))
}
