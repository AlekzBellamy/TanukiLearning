package rockthejvmscalaforbeginners

object Expressions extends App {

  /** Expresiones
    * Se evaluan/tienen a un valor y tienen un tipo
    * Las operaciones matematicas son expresiones al representar  operaciones entre numeso _+_, _-_  , * ,/ & | ^ << >> >>>.....
    * Los operadores tambien son expresiones  1==1 ó 1==x ==, !=,<,> <=, >=....
    * Los operadores logicos tambien son expresiones  ! && ||
    * Los operadores de cambio de variables  son expresiones  += -= /= *= estos tienen efectos secundarios
    */
  val x = 1 + 2
  println(x)

  println(2 == x)
  println(!(2 == x))

  var r0 = 2
  r0 += 1
  println(r0)

  /** Expresion
    * IF
    * Se considera que if es una expresion solo si se genera un value y un tipo como en el ejemplo siguiente, por lo cual If no es una instruccion
    */
  val aCondition = true
  val aConditionValue = if (aCondition) 1 else 0
  println(aConditionValue)

  /** nO usar While /loops
    * son muy específicos de la programación imperativa(JAVA)
    */
  var i = 0
  val aWhilt = while (i < 5) {
    println(i)
    i += 1
  }

  /** casi todo lo que hay en scala es una expresion
    */
  //Unit es  equivalente a void, es decir no hay nada que retornar
  //los efectos secundarios en scala son en realidad expresiones que devuelven unit

  //producen efectos secundarios  println , whiles, reassigning, expressions returning unit
  var aVariable = 1
  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)

  /** un bloque de codigo es una expresion
    * Todas lasvariables y otras expresiones declaradas dentro del bloque de codigo se queda en ese ambito,
    * y claro se puede tomar alguna variable del exterior que seguramente es otro bloque de codigo
    * quien lo contenga a este otro bloque y la otra variable exterior
    */
  val c = 10
  val aCodeBlock = {
    val a = 1
    val b = 2

    a == b || a > c
  }

  /** NOTAA: las instrucciones(ejecutadas) son de "JAVA"y las expresiones(evaluaciones) son de "scala"
    */

  val aHelloWorld = "Hellow World!" // Es una expresion de tipo string
  print(
    aHelloWorld
  ) // los efectos secundarios, son expresiones que regresan a la unit
}
