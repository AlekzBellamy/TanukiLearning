package rockthejvmscalaforbeginners.objectorientedprograming.part2oop

object Objects {
  // Scala no tiene funcionalidad de clase como en java que si ponias staticos algunos metodos o variables podrias acceder a ellas sin instanciar
  // Scala no sabe que es static,  lo mejor es que   Scala lo resuelve con objetos
  // Scala define la "funcionalidad de nivel de clase" por asi decirlo de la siguiente form
  // LA diferencia de esta definicion  dde object   y class de scala esque aqui no  se  reciben parametros
  // Caracteristicas principales
  // 1.- Un objeto  se usa como una instancia singleton!
  // 2.- Al ser singleton,esto define al objeto ser su propio tipo y es una unica instancia por definiciion sin ningun cambio alcodigo
  // 3.- PATRON COMPANIONS(compañeros) - Scala permite trabajar en el mismo archivo o alcance unca clase y un objeto con el mismo nombre!!!
  //     en donde dividimios la funcionalidad entre clases y objertos
  // 4 .- no confundir ante las definiciones, una vez que usamos companion, identificar las funcionalidad de cada instancia ya sea la regular o la singleton
  // 5 .- eb el object podemos crear  metodos  de fabricas(aquellos que se dedicaran a crear  instancias de la clase Person)
  object Person {
    val N_EYES = 2

    def canFly: Boolean = false

    def from(mother: Person, father: Person): Person = new Person("bobbie")
    // de manera conveniente este tipo de metodos ,  se usa el apply
    def apply(mother: Person, father: Person): Person = new Person(
      "bobbie"
    )
  }
  class Person(val name: String) {}

  def main(args: Array[String]) = {

    println(s""" ¡ ${Person.N_EYES}""")
    println(s""" ¡ ${Person.canFly}""")
    val p0 = Person
    val p1 = Person
    println(s""" ¡ ${p0 == p1}""") // es la unica instancia por eso da true

    val p2 = new Person("p2")
    val p3 = new Person("p3")
    val boobie = Person(p2, p3)
    println(s""" ¡ ${boobie.name}""")
    // Scala Applications
    // es un scala object con una particularidad
    // def main(args: Array(String)): Unit
  }
}
