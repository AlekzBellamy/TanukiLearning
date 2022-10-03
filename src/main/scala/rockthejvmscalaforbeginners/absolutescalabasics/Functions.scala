package rockthejvmscalaforbeginners.absolutescalabasics

object Functions extends App {

  /** Una funcion es una expression en scala
    */
  def aFunction(a: String, b: Int): String = a + " " + b

  println(aFunction("Alekz", 2))

  /** Las funciones  pueden ser recursivas, con esto se evitara usar loops lml
    * Las funciones recursivas si o si  requiere definir el tipo de retorno
    */
  def aRepeatedFunction(aString: String, nRepeat: Int): String = {
    if (nRepeat == 1) aString
    else aString + aRepeatedFunction(aString, nRepeat - 1)
  }
  println(aRepeatedFunction("Alekz", 2))

  /** Las funciones que retorna un tipo Unit, son funciones con efectos secundarios
    */
  def aFunctionSideEffects(aString: String): Unit = { println(aString) }
  aFunctionSideEffects("EfectosSecundarios")

  /** Los bloques de codifgo permiten definir funciones auxiliares dentro
    */
  def aFunctionOperations(foo: Int, baz: Int) = {
    def aFuctionSuma(a: Int, b: Int): Int = a + b //  una funcion auxiliar
    def aFuctionresta(a: Int, b: Int): Int = a - b //  una funcion auxiliar
    aFuctionSuma(foo, baz)
  }

}
