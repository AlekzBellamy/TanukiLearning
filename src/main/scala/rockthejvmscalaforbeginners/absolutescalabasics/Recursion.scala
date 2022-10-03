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

}
