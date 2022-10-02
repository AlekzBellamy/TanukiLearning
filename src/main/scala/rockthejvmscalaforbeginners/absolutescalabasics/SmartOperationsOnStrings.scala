package rockthejvmscalaforbeginners.absolutescalabasics

object SmartOperationsOnStrings extends App {

  /** *
    * Operaciones con variables tipo cadena
    * Tecnicamente tiene las operaciones de la maquina de java sobre los string
    * pero scala tambien tiene sus propias funiones lml
    */

  val str: String = "Hello, I am Alekz"
  println(str.split(" ").toList)

  val aNumberStr = "3561212"
  val aNumber = aNumberStr.toInt
// Los operadores antepuestos
// concatenan
  println('a' +: aNumberStr :+ 'Z')

  // reverse es de scala
  println(aNumberStr.reverse)
  // take
  println(aNumberStr.take(2))

  // String interpoladores

  //S -Interpolator --> concatenacion
  val name = "david"
  val age = 12
  val greeting = s"Hello, my is ${name}  and i am  $age years old!"
  println(greeting)

  val anotherGreeting =
    s"Hello, my is $name   and  i will turning ${age + 1} years old!"
  println(anotherGreeting)

  //F -Interpolator --> format

  val speed = 1.2f
  val myth = f"$name%s can ear $speed%2.2f  per minute"
  println(myth)

  val price = 2.5f
  val strFormart = f"$price%3.2f"
  println(strFormart)
  val price0 = 2
  val strFormart0 = f"$price0%3d"
  println(strFormart0)

  // raw - interpolator
  println(raw"this is a \n new lane")
  println("this is a \n new lane")
}
