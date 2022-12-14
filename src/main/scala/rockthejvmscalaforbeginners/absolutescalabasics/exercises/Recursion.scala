package rockthejvmscalaforbeginners.absolutescalabasics.exercises

import scala.annotation.tailrec

object Recursion extends App {

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
