package rockthejvmscalaforbeginners.pattermatching

object BracelessSyntax extends App {

  /** scala 3 puede apoyar eliminando las {}
    *
    * la expresion if, tiene varias formas de aplicarse, la queya vimos en scala, el tuipo java con {} y  en scala 3 nos permite usar la
    * sangria para omitir las {} y  tantas lineas dentro del bloque van identadas con tab
    *
    * Basicamente la identacion de la sangria permite lo loargo del bloque o para que scala diga esta e sla ultima lineade la expresion
    *
    * en clases , trait, objesst se pueden omitir pero se debe contemplar : para indicar que expresion va dentro del bloque
    * y al final un end nombre clase, para terminar la clase o bloque de la clase
    *
    * Sangira significatis. identacion
    */

  val ifExpresion = if (2 > 3) "a" else "b"

  val ifExpresion_javaStyle =
    if (2 > 3) {
      "a"
    } else { "b" }

  val ifExpresion_javaStyle_compact =
    if (2 > 3)
      "a"
    else
      "b"

  /** Scala 3 sangria identacion siempre respetar los espacios entre los bloques
    *  val ifExpresion_Scala3 =
    *    if 2 > 3 then
    *      "a"
    *    else
    *      "b"
    *
    *  val ifExpresion_Scala3_identacion =
    *    if 2 > 3 then
    *      val x ="a"
    *      x
    *    else
    *      val x = "b"
    *      x
    *
    *  val ifExpresion_Scala3_identacion_compac = if 2 > 3  then "a" else "b"
    */

  /** for compresions
    */

  val aForcompresion = for {
    n <- List(1, 23)
    c <- List("negro", "blanco")
  } yield s"$n $c"

  /**  val aForcompresionScala3 = for
    *    n <- List(1, 23)
    *    c <- List("negro", "blanco")
    *   yield s"$n $c"
    */

  /** pattenr matching
    */

  val numero = 50

  val aMatch1 = numero match {
    case 1 => "uno"
    case 2 => "dos"
    case _ => "otro"
  }

  /** respetar la sangria identada
    *  val aMatch1_scala = numero match
    *    case 1 => "uno"
    *    case 2 => "dos"
    *    case _ => "otro"
    */

  /** metodos sin {}
    */

  def metodod(arg: Int): Int = {
    val x = 5
    x + 2
  }

  /** no importa cuantos espacios existan vacios, se termina el bloque hasta que la sangria identada cambie
    *  def metodod_scala3(arg: Int): Int =
    *    val x = 5
    *
    *    x + 2
    */

  /**  calses rasgos, objetos  enums pueden ser identados, perose tienen que colocar la definicion d eun token :  y end clases name y a funciones anonimas tambien
    */
  /**  class Animal :
    *    def eat : Unit = println("jei")
    *    end eat
    *  end Animal
    *
    *  val aNimal = new Animal:
    *    override def eat(): Unit = println("ptro animal")
    */
}
