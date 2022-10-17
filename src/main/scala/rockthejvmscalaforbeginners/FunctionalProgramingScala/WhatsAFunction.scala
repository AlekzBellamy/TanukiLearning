package rockthejvmscalaforbeginners.FunctionalProgramingScala

/** en java todo es un objeto, y siempre lo vemos definido en clases y metodo
  */

class Action {
  def method(value: String): Int = 1
}

/** en Scala  para laparte funcional cambia  de verse   como un objeto  o instancia de algo,
  * como una funcion, que  entra alguna valor y GENERA/DEVUELVE en muchas ocaciones otro
  */

trait MyFunction[A, B] {
  def apply(element: A): B
}

/** Usar funciones de primera clase, las cuales son  funciones con valores simples
  */
object WhatsAFunction extends App {

  val pruebaDouble = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  /** beneficio con escala como la expresion/funcion se quedo en un value puede utilizarse como una funcon .. repito de una clase
    * se deficnio en un valur como función
    *
    * }Entonces esta variable  que es una instancia de MyFunction , se puede llamar como si fuera una funcion--> dejo de ser un metodo no estricto  o por definicon
    */

  println(pruebaDouble(2))

  println(pruebaDouble)

  /**   println(pruebaDouble)
    *
    *  Aqui se presenta con esta definicion una clase ANONIMAAA!!
    * rockthejvmscalaforbeginners.FunctionalProgramingScala.WhatsAFunction$$anon$1@2133c8f8
    */

  /** scala  permite este tos tipos de funciones de fabrica , para lo que esta hecho pues
    *
    * function typoes -- FUNCTION .. FUNCTION1 ... FUNCTION22 -->  el consecutivo son los parametros a tomar
    *
    * val stringToIntIConverter: String => Int syntactic sugar
    */
  val stringToIntIConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntIConverter("3") + 4)

  /** Analizando adder es un
    * val adder: (Int, Int) => Int syntactic sugar
    */
  val adder: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  /** val adder: (Int, Int) => Int syntactic sugar
    */
  val adder0: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  println(adder(1, 4))

  /** se puede sintetizar que
    * Function types > Function[A,B,R] === (A,B)=> R
    */

  /** toidas las funciones de scala son objetos o instancias de las qclases que se derivan de la funcion de una funcion
    */

  /** EJERCICIOS
    *
    * 1.-  UNA FUNCION QUE DEFINA 2 CADENAS Y LAS CONCATENA
    * 2.- CONTINUAR YENDO A LA IMPLEMENTACION MyList y transformando i predicado,, transform  de MyPredicate,, and MyTransformer
    * into function Types
    * 3-. def¿ine una funcion que toque un in y retorne  otra guncion que  tome un int y retorne un int
    */

  val concatenar: Function2[String, String, String] =
    new Function2[String, String, String] {
      override def apply(v1: String, v2: String) = v1 + v2
    }
  val concatenar0: (String, String) => String =
    new Function2[String, String, String] {

      override def apply(v1: String, v2: String): String = v1 + v2
    }

  println(concatenar0("hola ", "alekz"))

  val myFunction: Function1[Int, Function1[Int, Int]] =
    new Function1[Int, Function1[Int, Int]] {

      override def apply(x: Int): Int => Int = new Function1[Int, Int] {
        override def apply(y: Int): Int = x + y
      }
    }

  val prueba1 = myFunction(2)

  /** como aun no se resuelve la funcion esto nos devuelve <function1>
    */
  println(prueba1)

  /**  nos retorna 6, debido que resuelve el segundo parametro
    */
  println(prueba1(4))

  val prueba2 = myFunction(2)(10)

  /** nos retorna 12, debido a que se inyecto el segundo aprametro de la segunda funcion currify
    *
    * las funciones currify tienen la propiedad de que pueden llamarse con multiples listas de parametros simplemente por su mera definicion
    */
  println(prueba2)
}
