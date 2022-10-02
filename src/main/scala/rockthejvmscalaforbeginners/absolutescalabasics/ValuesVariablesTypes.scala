package rockthejvmscalaforbeginners.absolutescalabasics

object ValuesVariablesTypes extends App {

  /**
   * VALUES
   * palabra clave val
   * Los values no pueden ser reasignados con otro valor(inmutables)
   * los values son recomendables, se prefiere a las variables
   * Los tipos de los values son opcionales, debido aque el compilador puede inferir el tipo del valor colocado en el lado derecho
   */
  val x: Int = 42
  val x0 = 42

  println(x)
  println(x0)

  val aString: String = "Hello, Scala!"
  val aBool: Boolean = true
  val aChar: Char = 'a'

  val aShort: Short = 5000
  val aLong: Long = 11231231231233444

  val aFloat: Float=2.9f
  val aDouble: Double=3.121

  /**
   * VARIABLES
   * palabra clave var
   * Las variables  pueden ser reasignados con otro valor(mutables)
   * Las variables generan efectos secundarios
   * Las variables no son recomendables
   * Los tipos de las variables son opcionales, debido aque el compilador puede inferir el tipo del valor colocado en el lado derecho
   */
  var aVariable : Int =5
  println(aVariable)
}
