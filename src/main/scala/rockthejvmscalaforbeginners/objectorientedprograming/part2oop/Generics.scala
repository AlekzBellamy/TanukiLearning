package rockthejvmscalaforbeginners.objectorientedprograming.part2oop

object Generics extends App {

  /** Para usar los geneericos, se define en la clase y en corchetes se le da un nomnbre al tipo --> class xxxx[A]
    * una vez definido podemos usar el tipo A dentro del bloque de la clase
    */

  class MyList[A] {}

  /** se al usarlo ,  se puede instanciar pasandole ala clase generica el tipode dato con el que trabajara
    */
  val mylist1 = new MyList[Int]
  val mylist0 = new MyList[String]

  /** se puede poner  varios tipos en la clase generica, tantos que se desee
    * NOTA los trait/rasgos tambien pueden  ser parametrizaados
    */

  class MyMap[Key, Value] {}

  ///Metodos genericos D=
  object MyList {
    // al igual que las clases los metodos pueden parametrizar con generios,
    // el uso de un metodo generico es para que retorne alguna clase generica del mismo tipo con A
    def empty[A] = MyList[A]
  }

  // como se consumiria un metodo generico
  val emptyListIntegers = MyList.empty[Int]

  // problema de la varianza

  /** Las varianzas describen las relaciones de sub-tipos de tipos complejos y las relaciones de sub-tipos de sus tipos de componentes.
    */
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  /** Si Cat extiende de animales,  y si se hace una lista de Cat ,la lista tambien extiende de animales??????
    */

  /** 1 .- si , la lista extiende de animales List[Cat] extends List[Animal]
    * COVARIANCE -Covariable
    * Este comportamiento se llama covarianza y la forma que declaras una lista covariante es la siguiente
    * La anotación +T declara que el tipo T sea utilizado solamente en posiciones covariantes
    * La co-variance o covarianza, describe la flexibilidad que hay en que un tipo pueda considerarse sub-tipo de otro tipo en una definición genérica.
    */
  class CovariantList[+A] // + > significa que esta e suna lista covariante
  // para usarlo sera lo siguiente
  val animal: Animal = new Cat
  val animals: CovariantList[Animal] = new CovariantList[Cat]

  // en esta primera covariante, se tiene que  trabajamos una lista de Animal, pueden agregarse a la lista de gatos, un perro, debido a que eperro y gato son animales(extienden de animal)
  // esto permite que la lista tenga ambos subclases(ensucia la lista)

  /** 1 .-No, lista de Cat y lista de Animal , son cosas diferentes,
    * INVARIANCE - invariable
    *   La forma de delcararla es la siguiente
    *   Basicamente  el invariante,  si defina una lista invariable de animales, esta no puede ser sustituidad como lista invariable de gatos o perro, tiene que ser de animal para que no falle elcompilador
    * cada tipo esta en su propio mundo
    * La contra-variance o contravarianza, es lo opuesto a la covarianza pues define la flexibilidad de hacer a un tipo, sub-tipo de su sub-tipo por la relación que existe entre ellos
    */
  class InvariantList[A]
//se usa de asi
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  /** 3 .- Contra variance- CONTRAVARIABLE
    * se define con un signo menos antes del generico
    * Es la relacion opuesta a covarianza
    * -T declara que T sea usado en posiciones contravariantes.
    * Y claro también existe la in-variance o invarianza, que no es flexible y que limita la varianza entre tipos ya que si definimos una clase o trait genérico como invariante entonces no vamos a incluir a sus sub-tipos de ninguna forma actuando de forma rígida en la definición
    */
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]

  val trainertList: Trainer[Cat] = new Trainer[Animal]

  /** Para una clase anotada como class List[+A] y teniendo dos tipos A y B, donde A es sub-tipo de B, List[A] es sub-tipo de List[B], o es covariante.
    * Para una clase anotada como class List[-A] y teniendo dos tipos A y B, donde A es sub-tipo de B, List[B] es sub-tipo de List[A], o es contravariante.
    * Para una clase que no tenga anotación class List[A] y teniendo dos tipos A y B, donde A es sub-tipo de B, List[A] es NO es sub-tipo de List[B], o es invariante.
    */

  // BOUNDED TYPES--delimitados de tipos
  // permiten usar sus clases genericas para ciertos tipos que son  una subclase de un tipo diferente o una superclase de un tipo diferente
  // <: operador , signfica que la clase solo acepta parametros de tispo que son subtipos de animales
  class Cage[A <: Animal](animal: A)

  val cage =
    new Cage(new Dog) // podra recibir subtipos de animal por el delimitador

  class Car
  //val car= new Cage(new Car)

  // al igual que el delimilador <: existe >: que slo acepta los superclases

}
