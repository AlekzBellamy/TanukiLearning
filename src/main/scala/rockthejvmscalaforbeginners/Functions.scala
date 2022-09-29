package rockthejvmscalaforbeginners

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

  /** *
    * EJERCICIOS
    * 1 . una funcion de saludo para niños, debe recibir 2 parametors  nombre y edad y debe decir "Hi, My name is $name and i am $age years old"
    * 2 . crear una funcion factorial 1*2*3 ...n (recursive function)
    * 3 . crear una funcion fibonacci
    *      f(1) = 1
    *      f(2) = 1
    *      f(n)= f(n-1) + f(n-2)
    * 4 . una funcion que pruebe si un numero es primo
    */

  def greetingKid(name: String, age: Int): String = {
    //s"Hi, My name is $name and i am $age years old"
    "Hi, My name is " + name + " and i am" + age + " years old"
  }

  println(greetingKid("Felipe", 14))

  def factorial(n: Int): Int = {
    //if (n == 1) n correccion no se contempla que cualquier numeero menor a 0 es 1
    if (n <= 0) 1
    else n * factorial(n - 1)
  }
  println(factorial(5))

  def fibonacci(n: Int): Int = {
    //if (n <= 1) 1 correccoin se tiene que contemplar el 2 como limitante
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  }
  println(fibonacci(8))

  def isNumeroPrimo(n: Int): Boolean = {

    def isNumeroPrimo0(d: Int): Boolean = {
      //if (d == 1) true  se tiene que contemplar valroes menor a 1
      if (d <= 1) true
      else if (n % d == 0) false
      else isNumeroPrimo0(d - 1)
    }
    isNumeroPrimo0(n - 1)
  }

  println(isNumeroPrimo(37))
  println(isNumeroPrimo(2003))
  println(isNumeroPrimo(37 * 17))
}
