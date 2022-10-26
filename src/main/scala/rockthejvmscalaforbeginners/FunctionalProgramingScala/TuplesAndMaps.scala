package rockthejvmscalaforbeginners.FunctionalProgramingScala

import sun.rmi.transport.Target

import scala.annotation.tailrec

object TuplesAndMaps extends App {

  /** las tuplas son listas finitas y ordenadas
    * t._1 // accedemops por posicion
    * t.copy()//gerneramos otra instancia con los valores de la instancia copiada(obvio los podemos actualizar)
    * t.toString
    */
  val aTupleORg = new Tuple2(2, "Hola Scala") // tuple[Int, Sitrng]
  val aTuple = (2, "Hola Scala") // (Int, String) sugar syntactc
  println(aTuple)
  println(aTuple._1)
  println(aTuple._2)
  println(aTuple.copy(_1 = 10, _2 = "nada"))
  println(aTuple.swap)

  /** Maps  Keys -> Values
    * son colecciones que se usan para asociar con otras cosas
    * practico para generar asociaciones
    */

  val aMap: Map[String, Int] = Map()
  val phonebook0 = Map(("Jim", 555), ("alekz", 777))
  val phonebook1 = Map("Jim" -> 555, "alekz" -> 777) // sugar Syntactic ->
  val phonebook = Map("Jim" -> 555, "alekz" -> 777).withDefaultValue(
    -1
  ) // se usa para no dar error si no se encuentra la clave buscada
  println(phonebook0)
  println(phonebook)

  /** operaciones basicas de maps
    */
  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))
  println(phonebook("mary"))

  /** añadir un item
    */
  val neewPairing = "mary" -> 342
  val newPhonebook = phonebook + neewPairing
  println(newPhonebook)
  println(newPhonebook("mary"))

  /** funciones sobre mapas
    * map. flatmap, filter
    */

  println(newPhonebook.map { p => p._1.toUpperCase -> p._2 })

  println(newPhonebook.view.filterKeys(x => x.startsWith("a")).toMap)
  println(newPhonebook.filter(_._1.startsWith("a")))
  println(newPhonebook.view.toMap)
  println(phonebook.mapValues(number => number * 10).toMap)
  println(newPhonebook.view.mapValues(number => number * 10).toMap)

  // otras colecciones
  // genera lista de tuplas
  println(newPhonebook.toList)
  println(List(("Jim", 555), ("alekz", 777), ("mary", 342)).toMap)

  val names =
    List("bob", "angela aguilar", "maribel guardia", "dani phantom", "alekz")
  println(names.groupBy(name => name.charAt(0)))

  /** Ejercicios
    * 1.- que sucede si tenemos dos claves las cuales son diferentes por mayusculas, y aplicamos una funcion para que sean todas minusculas?
    */
  val phonebookE = Map(("Jim", 555), ("JIm", 777))
  println(phonebookE)
  println(
    phonebookE.map(p => p._1.toUpperCase -> p._2)
  ) // si existen varaibles = pero se distinguen por las mayusculas
  // y minusculas, y a estas las formalizas con todas mayusculas o todas minusculas, tomara el ultimo valor de la lista
  // es decir, cuando existen clases iguales la ultima se superpone

  def add(
      network: Map[String, Set[String]],
      person: String
  ): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], a: String, b: String) = {
    val friendA = network(a)
    val friendB = network(b)

    network + (a -> (friendA + b)) + (b -> (friendB + a))
  }

  def unFriend(
      network: Map[String, Set[String]],
      a: String,
      b: String
  ): Map[String, Set[String]] = {
    val friendA = network(a)
    val friendB = network(b)

    network + (a -> (friendA - b)) + (b -> (friendB - a))
  }

  def delete(
      network: Map[String, Set[String]],
      person: String
  ): Map[String, Set[String]] = {
    def deleteAux(
        friends: Set[String],
        networkAcc: Map[String, Set[String]]
    ): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else deleteAux(friends.tail, unFriend(networkAcc, person, friends.head))
    }
    val unfirend = deleteAux(network(person), network)
    unfirend - person
  }

  def nfirends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else (network(person).size)

  def mostFriends(network: Map[String, Set[String]]): String = {
    network.view.maxBy(p => p._2.size)._1
  }

  def nPeopleWithnotFriends(network: Map[String, Set[String]]): Int = {
    network.filterKeys(k => network(k).isEmpty).size
    network.filter(_._2.isEmpty).size
    network.count(_._2.isEmpty)

  }
  def socialConnection(
      network: Map[String, Set[String]],
      a: String,
      b: String
  ): Boolean = {
    @tailrec
    def bfs(
        target: String,
        considerePeople: Set[String],
        discoveredPeople: Set[String]
    ): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (considerePeople.contains(person))
          bfs(target, considerePeople, discoveredPeople.tail)
        else
          bfs(
            target,
            considerePeople + person,
            discoveredPeople.tail ++ network(person)
          )
      }
    }
    bfs(b, Set(), network(a) + a)
  }
  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "bob"), "Mary")

  println(network)
  val friends = friend(network, "bob", "Mary")
  println(friends)
  val unfriends = unFriend(friends, "bob", "Mary")
  println(unfriends)

  val delete0 = delete(friends, "bob")
  println(delete0)

  /** mas amigos
    */

  val network2 = add(add(add(empty, "bob"), "Mary"), "jim")
  println(network2)
  val jimbob = friend(network2, "bob", "jim")
  println(jimbob)
  val marybob = friend(jimbob, "bob", "Mary")
  println(marybob)
  val total_friends = nfirends(marybob, "bob")
  println(total_friends)
  val most_friends = mostFriends(marybob)
  println(most_friends)
  val none_friends = nPeopleWithnotFriends(marybob)
  println(none_friends)

  val social = socialConnection(marybob, "bob", "jim")
  println(social)
}
