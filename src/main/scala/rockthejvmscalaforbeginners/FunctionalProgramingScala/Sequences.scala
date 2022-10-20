package rockthejvmscalaforbeginners.FunctionalProgramingScala

import scala.util.Random

object Sequences extends App {

  /** Son  una interfaz para las estructuras de datos,
    * estas tienen dos propiedades
    *  un orden definido y pueden ser secuencias indexadas
    *
    *  soportes
    *  metodo apply , iterator, lengh, reverse
    *  concatenacion , appending, prepending
    *  grouping, sortiing, zipping m searching, slicing
    */

  val aSequence = Seq(1, 2, 3, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(0))
  println(aSequence ++ Seq(5, 6, 7, 8))

  /** rangos Range
    */

  val range: Seq[Int] = 1 to 10
  val range0: Seq[Int] = 1 until 10

  println(range)

  range.foreach(println)

  /** List
    * Es una LinearSeq, es inmutable
    * tiene gead, tail, isEmptu metjods rapidos
    *  indexado, leng ,reverse
    *
    *  Las listas estan selladas y  tienen como dicho dos tipos,,
    *  Nil .. lista vacia
    *  class :: colom
    */

  val aList = List(1, 2, 3)
  val prepended = 42 :: aList
  val prepended0 = 42 +: aList :+ 100
  println(prepended)
  println(prepended0)

  /** se peude generar una liste rellenando uinformacion
    */
  val apples5 = List.fill(5)("manzana")
  println(apples5)

  println(apples5.mkString("  &-&  "))

  /** Arrays ,  igual al de JAva
    * Se pueden construir por longitudes predefinidad, es decir guarda los espacions en memoria aunque no se usen aun
    *  pueden mutar,
    *  es indexada rapida
    *  Array y Seq????
    */

  val numbres = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3)

  println(numbres)
  println(threeElements)
  threeElements.foreach(println)

  //Mutacion
  numbres(3) = 0
  println(numbres.mkString(" - "))

  val numberToSeq: Seq[Int] = numbres // existe un implicit conversion
  println(numberToSeq)

  /** Vectores
    *  es una inplementacion de las secuencias inmutbles
    *  ofrece lectura y ecritura
    *  performance en tamaños grandes
    */
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  /** vectors vs list
    */

  def getWriteTime(collections: Seq[Int]): Double = {
    val r = new Random
  }
}
