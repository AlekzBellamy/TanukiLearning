package rockthejvmscalaforbeginners.pattermatching

import scala.util.Random

object PatterMatching extends App {

  /** El uso de coincidencia de patrones es como una cambio de esteroides
    */

  val random = new Random(
  )
  val x = random.nextInt(5)

  /** esta expresion es la coincidenca de patrones  e intenta como tal coincidir copn el valor con multiples patrones
    * y cada coincidencia escribe una declaracion de caso
    */
  val descriopcion = x match {
    case 1 => "uno"
    case 2 => "dos"
    case 3 => "tres"
    case _ => "cualquier valor" // wildcard coincide con cualquier otro valor
  }
  println(x)
  println(descriopcion)

  /** una de ls caracteristicas de la coincidencia de patrones e sque puede descomponer valores especialemnt uados junto
    * con clases de claves
    * los casos de clase tienen la capacidad de deconstruirse y extraerse en la coincidencia de patrones
    */

  case class Person(name: String, age: Int)

  val bob = Person("bob", 15)

  /** el match ṕermite deconstruir las case class  y podemos usar sus campos en la coincidencia
    * se le puede poder una guardua / como un filtro  case Person(n, a)  if a < 21
    */
  val saludo = bob match {
    case Person(n, a) if a < 20 => s"Hola  mi nombre es $n y  soy menor de edad"
    case Person(n, a)           => s"Hola  mi nombre es $n y tengo $a años"
    case _                      => "persona desconocida"
  }
  println(saludo)

  /** hayq ue contemplar que los casos se emparejan en orden para que los casos se toman sucesivamente en la primera parte
    *
    * hay que contemplar que se contemplen todos las coincidencias, en caso de no coocarla o olviudad el wildcar _ , podra arrohjar un MatchError
    *
    * El tipo de expresion de coincidencia es la unificacion de todas la expresiones devueltas por todos los casos, para
    * si todos los catos devuelven string, la expresion sera como resultado string, pero si devuelve tipos diferentes sea un Any
    *
    * otra caracteristiva es la coincidencia para la jkerarquia, y lo mejor aun que cuando esto sucede el compilador podra
    * definir los casos exauitivamente, por cual si omitimos uno el compilador hara la obseervadoer y esto debido a que la clase padra  esta sellada (sealed)
    * sealed class apoyaran a no omitir algun case lml
   *
   * el patron de coincidencia trabaja muy bien con los casos de clase
    */

  sealed class Animal
  case class Dog(bread: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animalm: Animal = Dog("terra nova")
   animalm match
     case Dog(s) => println(s" match perro  $s bread")
     case Parrot(g) => println(s"parroit greattimng $g")
     case _ => println("desconozco el anuimal")

  /**
   * EJERCICIO
   *
   * escribit una funcion simple que usa la coicidencia de patrosnes y toma una una exprecion ocmo parametro
   *
   */

  trait Expr
  case class Number(n: Int ) extends Expr
  case class Sum(e1: Expr, e2: Expr ) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr) : String = e match {
    case Number(n) => s" $n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) =>
      def agregaParentesis(expr: Expr) = expr match {
        case Prod(_, _) => show(expr)
        case Number(_) => show(expr)
        case _ => "(" + show(expr) + ")"
      }

      agregaParentesis(e1) + " * " + agregaParentesis(e2)
  }


  println(show( Sum(Number(1), Number(5))))
  println(show( Sum(Prod(Sum(Number(1), Number(5)),Sum(Number(1), Number(5))),Prod(Sum(Number(1), Number(5)),Sum(Number(1), Number(5))))))

}
