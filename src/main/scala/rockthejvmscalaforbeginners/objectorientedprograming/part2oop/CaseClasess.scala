package rockthejvmscalaforbeginners.objectorientedprograming.part2oop

object CaseClasess extends App {

  /** Las clases de casos son una abreviatura excepcional util para definir una clase y el objeto comprlemtenrario  y una gran cantidad
    * de valores predeterminados razonables de una sola vez
    *
    * sirve para crear  clases de almacenamiento de datos livianos con una molestia minima
    */

  /** Los parametros de clase se promueven en campos
    */
  case class Person(name: String, age: Int)

  /** 1 .-  Los parametros de clase se promueven en campos,
    * no es necesario usar el val como en la clase
    */
  val p = new Person("p", 12)
  println(s""" person ${p.name}""")

  /** 2.- Es sencible al toString
    * es una presentacion de dos cuerdas
    * print(instance) == print(instance.toString)
    */
  println(p.toString)

  /** 3 .- Equals y hashCode  estan implementadospor default que es espacialmente para colecciones
    */

  val p0 = new Person("p", 12)
  println(p == p0)

  /** tienen metonos de clone- copy utile
    * al cual puede modificarle alguna variable generando una nueva instancia
    */
  val p1 = p.copy(age = 14)
  println(p == p1)
  println(p1.toString)

  /** 5 .- tienen  objetos de compañia, es decir la clase es un objeto complementario
    * de la misma clase de casos.
    * los objetos complementarios tambien tienen algunos metodos practicos de fabrica
    *
    * esto permite crear instancias  ni la clave new porque nos proporciona el constrcuctro
    */
  val thePerson = Person
  val thePerson0 = Person("h", 1)
  println(thePerson)
  println(thePerson0)

  /** 6- la clases de casos son serializables, lo que permite enviar informacion   las instancias a travez de red y JVM
    *
    * 7.- Las clases de casos  tienen patrones de extractor, las cuales pueden ser usadas en  pattern machitch( coincidencia de patrines)
    */

  /** Tambien existe un objeto de caso, que actua como una clase exepto que e sun objeto, y que tienen la misma propuiedad que las clases de caso
    */

  /** Ejercicio expandir  MyList en una clase de caso y en un caso de objetos
    */
}
