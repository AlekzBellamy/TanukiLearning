package rockthejvmscalaforbeginners.objectorientedprograming.part2oop

import java.security.cert.Extension

object InheritanceAndTraits extends App {

  // Herencia y rasgos
  //Super clase  (clase padre) Sub Clases(Clase que hereda/extiende)
  // scala como otros lenguajes solo puede extender unca clase a la vez
  // aligual que otro lenguajes , extan los modificadores
  //public -> la instancia de la subclase puede acceder al value o metodo
  //protected -> solo  la subclase puede acceder al value o metodo
  //private -> solo  la la super clase puede usarla

  class Animal {
    def eat = println("nomnom")
    val creatureType = "wild"
  }
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch ")
    }
  }
  val cat = new Cat
  cat.crunch
  // cuando la super clase tiene parametros, la sub clase debe extender  describiendo los datos del contructor de la super clase
  // se pueden hacer uso de los constructores personalizados
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
  class Young(name: String, age: Int, idCard: String) extends Person(name)

  // Sobreescribir --> cambia la implementacion del metodo como en otros lenguajes,,, peroo tambien a las variables

  class Dog extends Animal {
    override def eat = println("crunch")

    override val creatureType = "domestic"
  }
  val dog = new Dog
  dog.eat
  println(dog.creatureType)

  // Se puede aplicar la sobreescritura en el pase de parametro de la clase(Anulacion)
  // Las siguientres clases Bird son la misma implementacion

  class Bird(override val creatureType: String) extends Animal {
    override def eat = println("brr brr")
  }

  class Bird0(birdType: String) extends Animal {
    override val creatureType = birdType
    override def eat = println("brr brr")
  }

  val bird = new Bird("Fantasy")
  bird.eat
  println(bird.creatureType)

  // la sobre escritura permite el el tipo de substitucion llamado polimorfismo

  val unknownAnimal: Animal = new Bird("wild")
  unknownAnimal.eat

  // sobreescritura vs sobre carga
  // sobre escritura --> permite reimplementar
  // sobrecarga --> proporcionar multiples metodos con diferentes firmas

  // SUPER -- >  se usa cuando se requiere hacer referencia a un metodo o campo de la super clase

  class Bear extends Animal {
    override def eat = {
      super.eat
      println("grr grr")
    }
  }
  val bear = new Bear
  bear.eat

  // prevencion de sobreescrituras
  // 1 usar la palabra clave final al campo o metodo --> se evita la reimplementacion
  // 2 usar final a la clase --> se evita el extends
  // 3 sellar la clase, es decir extender en las clases del mismo archivo pero evitar la extencion en archivos externos "sealed"
  //  el sealed se utiliza cuando se quiere ser exhauntivo en su jerarquia de tipos
}
