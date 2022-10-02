package rockthejvmscalaforbeginners.absolutescalabasics

import scala.annotation.tailrec

object Recursion extends App {

  /** RECURSION
    * Un problema detectado es cuando la recursividad es demasiada profunda  puede generar error StackOverFlowerror y se detiene
    * El problema de esta recursividad es que se ne necesita un marco de piulas de llamadas recursivas para cada llamada recursiva
    * para que calcule el resultado intermedio y luego pueda multiplicarlo con el nuemero y devolverlo desde la pila
    *
    * 5 * f(5-1) * f(4-1) * f(3-1) * f(2-1) -> n veces
    * No necesita Conservar el marco de pila
    */
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  /** Una recursion  de otra manera que evite la profundidad?
    * Con un helper y un acumulativo puede soportar un numero grande, hablamos de una recursividad """sin profundidad"""
    * el helper  se definio como  la ultima expresion de su ruta de codigo, lo cual permite que scala conserve el marco estatico ,
    * y no use marcos estaticos adicionales par las llamadas de recursividad
    * Esta recursion se llama cola  recursiva, usa llamada recurva a la ultima expresion
    * f(9,10*1)
    * f(8,9*10*1)
    * f(2,2*3*4*5*6*7*8*9*10*1).....
    * Una forma  truco para evalusar que la recursividad es una cola recursiva es colocar la anotacion @tailrec lml, si no es una de este tipo marca error
    * NOOOOTAAA ->  CUANDO REQUIRAMOS LOOPS  UTILIZAR COLAS RECURSIVAS
    */

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: BigInt, acc: BigInt): BigInt = {
      if (x <= 1) acc
      else factHelper(x - 1, x * acc)
    }

    factHelper(n, 1)
  }

  println(anotherFactorial(1))

  /** EJERCICIOS
    * 1. Concatenar un String n times(Tail Recursive)
    * 2. una funcion para validar numeros primos  (Tail Recursive)
    * 3 . fibonacci function  (Tail Recursive)
    */

  def repeatStrings(text: String, n: Int): String = {
    @tailrec
    def concatHelper(x: Int, textAcc: String): String = {
      if (x <= 1) textAcc
      else {
        concatHelper(x - 1, textAcc + text)
      }
    }
    concatHelper(n, text)

  }

  println(repeatStrings("Alekz", 5))

  /** Mejor eelabodaro
    */
  @tailrec
  def concatenateTailRec(aString: String, n: Int, acc: String): String = {
    if (n <= 0) acc
    else concatenateTailRec(aString, n - 1, aString + acc)
  }

  println(concatenateTailRec("hello", 3, ""))

  def isNumeroPrimo(n: Int): Boolean = {
    @tailrec
    def isNumeroPrimo0(d: Int): Boolean = {
      if (d <= 1) true
      else if (n % d == 0) false
      else isNumeroPrimo0(d - 1)
    }

    isNumeroPrimo0(n - 1)
  }
  println(isNumeroPrimo(59))

  /** mejor presentacion
    */

  def isPrime0(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeTailRec(n / 2, true)
  }
  println(isPrime0(59))
  println(isPrime0(2003))
  println(isPrime0(600))

  /** Pendiente realizar
    */

  /** presntacion
    */

  def fibonacci0(n: Int): Int = {
    @tailrec
    def fibTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibTailRec(i + 1, last + nextToLast, last)
    }
    // preparado de inicio
    if (n <= 2) 1
    else fibTailRec(2, 1, 1)
  }

  println(fibonacci0(8))
}
