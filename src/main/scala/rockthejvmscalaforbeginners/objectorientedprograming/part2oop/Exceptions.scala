package rockthejvmscalaforbeginners.objectorientedprograming.part2oop

object Exceptions extends App {

  /** Lanzar y cachar excepciones
    * el manejo de excepciones permiten que el programa no se detenga y continue
    */

  /** lanzamos una excepcion como en otros lenguaje
    * lanzar una excepcion es una expresion
    *
    *  las clases extienden de Throwable Clases
    *  exception  y error son  suvtipos de throwable
    */
  //val exception = throw new NullPointerException()

  /** como atrapar/cachar  excepciones
    */
  def getInt(item: Boolean): Int =
    if (item) throw new RuntimeException("nope")
    else 42

  try { getInt(false) }
  catch {
    case eq: RuntimeException => println("error runtime")
  } // en el xase debe coincidr con la excepcion propagada o esperada, ya que si no se contempla se detendra el progama
  finally { println("que hacer si truena") }

  /**  si un try retorna en el error un  tipo  diferente alesperado  , no devolvera un anyVal
    * ademas el finally no influye en el tipo de retorno de la expresion  y ademas es opcional
    * utilizar  solo para efectos secundarios
    */

  /** podemos definir nuestra propias excepciones
    */

  class MyExceptions extends Exception {}
  //val myException = new MyExceptions
  //throw myException

  /** Ejercicios
    * 1.- crear una expresion que bloquee el programa con un error de falta de memory
    * 2 .-  quiero que se bloquee con un error de desbordamiento de pila
    * 3.- definir una pequela calculadora de bolsillo, dos operaciones
    *       -- add (x,y)
    *       -- substract
    *       -- multiply(x,y)
    *       --divide(x/y)
    *        lanzar una excepcion personalizada si ocurre algo incorrecto
    *
    *        OverFlowException if add(x,Y) exceds Int Value
    *        UnderFlowException if substract (x,y) excets int.Min value
    *        MatCalculationException para la division si es divivida x0
    */

  def errorOutMemory(): Int = throw new OutOfMemoryError()
  def errorStackOF(): Int = throw new StackOverflowError()

  object Calculator {
    def suma(x: Int, y: Int): Int =
      if ((x < Int.MaxValue && y < Int.MaxValue) || (x + y) < Int.MaxValue)
        x + y
      else throw new OverFlowException

    def -(x: Int, y: Int): Int = ???
    def *(x: Int, y: Int): Int = ???
    def /(x: Int, y: Int): Int = ???

  }

  class OverFlowException extends Exception {}
  class UnderFlowException extends Exception {}
  class MathCalculationException extends Exception {}

  val calculator = Calculator
  println(calculator.suma(2147483647, 2147483647))

}
