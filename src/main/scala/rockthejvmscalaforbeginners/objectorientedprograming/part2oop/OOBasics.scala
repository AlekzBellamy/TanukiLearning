package rockthejvmscalaforbeginners.objectorientedprograming.part2oop

object OOBasics extends App {
  val person = new Person("Jhon", 26)

  val person0 = new Person0("Jhon", 26)
  //println( new Person("Jhon", 26).age) // no se puede acceder alos parametros de clase,
  println(person0.age) //solo si se le agrega la palabra clave val

  val person1 = new Person1("Jhon", 26)
  println(person1.x)
  person1.greet("Pablo")
  person1.greet()
}

class Person(
    name: String,
    age: Int
) // en scala esta definicion a una clase  es un constructor,
// ahora , este tipo de constructor se caracterizapor que los parametros son de clase, pero no son miembros de la clase
// al que se puede accder como en otros lenguajes (JAva), es decir no son campos

class Person0(
    name: String,
    val age: Int
)
//para cambiar esto se tiene que calificar con val  previo al nombre del parametro
// un constructor especifica lo que la clase si o si debe tener  al  instanciarse
//El compilador solicitara en casa instancia los valores!

//Parametros de clase vs campos de clase (el primero no puede acceder de la froma convencional ".field")
class Person1(name: String, val age: Int) {
  //body , el cuerdo de la clase no es un expresion pero defina la implementacion de la misma
  // se puede  hacer cualquier cosa dentro del bloque de body  que se pueda hacer en una expresion de bloque

  val x = 2 // las variables definidas  pueden ser utilizadas en su instancia
  println(x * 2)

  //Method
  def greet(name: String): Unit = {
    println(s"${this.name} says: Hi $name")
  }
//Sobrecarga metoods con el mismo nombre pero diferentes parametros de entrada
  def greet(): Unit = {
    println(
      s" Hi , I am ${this.name} "
    ) // This es un implicito// al igual que ene otro slenguajes se
    // utiliza para eliminar ambiguedad y selecciona a la variable de la clase y no del metodo
  }

// Multiple constructores,
  def this(name: String) = this(name, 0)
  def this() = this("Alekz")
}
