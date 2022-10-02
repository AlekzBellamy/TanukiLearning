package rockthejvmscalaforbeginners.absolutescalabasics

import scala.annotation.tailrec

object DefaultAndNamedArguents extends App {

  /** Escala permite tener valores default en las definiciones de parametros de las funciones, algo chevere para omitir pasar
    * en algunos inicializadores , o  com se hacia en  otro lenguaje poner un  contador/acumulador como variable global  o de ambito
    * NOTA: el valor default aporta en poner como una opcionel sudo del parametro , si no se define la variable toma el valor default,
    * y en caso de que si se coloque  tomara el valor pasado lml
    */

  // se puede pasar el valor default a un parametro de llamada por nombre??

  def prueba(x: => Int = 2): Int = {
    x
  }

  println(prueba(1))
  println(prueba())
  println(prueba(trFact(5)))

  @tailrec
  def trFact(n: Int, acc: Int = 1): Int = { // el acumulador puede inicializar en 1 y omitimos pasar en el uso de la funcion  acc
    // (es decir no se vuelve como obligatorio) y no impide pasar el valor

    if (n <= 1) acc
    else trFact(n - 1, n * acc)
  }

  println(trFact(10))

  /** *
    * Al definir varios parametros  cuando  en algunas ocasiones se coloca el valor por defauld,  se levantaran unos warning
    * debido a que el ide / scala estara confundido para saber el valor pasado  a que parametro corresponde
    */
  def savePicture(
      format: String = "jpg",
      withd: Int = 1200,
      height: Int = 900
  ): Unit = println("savePicture!")

  /** La solucion para que no se confunda los valores aque parametro corresponde es
    * 1.  pasar los argumentos en orden
    * 2. nombrar cada argumento pasado(puede ser en desorden)
    */
  savePicture(withd = 100, format = "flv", height = 1900)
}
