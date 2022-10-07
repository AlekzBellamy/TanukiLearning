package rockthejvmscalaforbeginners.objectorientedprograming.part2oop

/** LAs clases abstractas  no se pueden instanciar, se pueden extender lml
  * son  definiciones que pueden ampliarse
  */
object AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }
  // cuando se extiende de una clase abstracta, solicitara el compilador por su deficion,
  // implementar las variables y definiciones
  class Dog extends Animal {

    override val creatureType: String = "canino"

    override def eat: Unit = println("guau guau")
  }

  // TRAITS
  // mejores tipos de datos abstractos, tienen campos y metodos  abstractos
  // como las clases abstractas, pero la diferencia y mejor es que pueden heredarse entre clases
  // se pueden mezclar tantos rasgos/ clases que se pueda

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    val creatureType: String = "croc"

    def eat: Unit = println("nom nom")

    def eat(animal: Animal): Unit = {
      println(s""" i am a croc and i ´m eating ${animal.creatureType}  """)
    }

  }

  val dog = new Dog()
  val croc = new Crocodile()

  croc.eat(dog)

  /// NOTA los datos abstractos y trait se parecen mucho yaque trabajan con tipos de datos abstractos o no abstractos
  // sin embargo , los trait tienen las siguientes caracteristicas
  // 1.- los rasgos no tienen parametros de constructor
  // 2.- solo se puede extender una clase perooo se pueden mezclar multiples traits/rasgos
  // 3 .- lo sutil de los trait es su propio nombre son para definir comportamientos
  // mientras que las clases abstractas describen lo que hacen los tipos de datos
}
