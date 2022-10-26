package rockthejvmscalaforbeginners.FunctionalProgramingScala

import scala.util.Random

object Options extends App {

  /** null  laproblematica de las referencias que causa bloqueos en los procesos, por lo cual  Option    nace o se define, debido a que
    * debe  encapsuar la posible ausencia de un valor, entonces una opcion es un ocntenedor para un vvalor que pueda estar ausente
    * Some -> existe algoun valor
    * None ->  ausencia de un valor
    *
    * NOTAAA no trabajar some(null)  pero si trabajar Option(null) debido a que se encargaria de devolver none en caso ser null
    *
    * Option sirve para eviar el tuido y bloqueos en ejecucion, evita un espgueti dsn aserciones
    * Es una forma de lidiar con la posible ausencia de unvalor
    * si existe algun metodo o funcion que renote quizas un null , mejor trabnje con option
    */

  val op = Some(3)
  val none = None
  def unsafeMethod(): String = null
  val result = Option(unsafeMethod())
  println(op)
  println(none)
  println(result)

  /** metodos encadenads
    * getorelse, utiloizar metodos seguros que retornen option, some  y none
    */

  def bettrUnsafeMethod(): Option[String] = None
  def beterBackupMethod(): Option[String] = Some("algo")

  val t = bettrUnsafeMethod() getOrElse beterBackupMethod()
  println(t)

  println(op.isEmpty)
  println(
    op.get
  ) // es un metodo inseguro porque puede ser un nullpoiner --> no usar
  println(op.map(_ + 2))
  println(op.filter(_ > 0))
  println(op.filter(_ > 10))

  println(op.flatMap(x => Option(x * 10)))

  /** Ejercicio para trabajar con options
    */

  val config: Map[String, String] = Map(
    "host" -> "1.1.1.1",
    "port" -> "90"
  )

  class Connection {
    def connect = "conectado"
  }
  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else none
  }

  val host = config.get("host")
  val port = config.get("port")

  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))

  //println(connection)
  //println(connection.map(c => c.connect))

  config
    .get("host")
    .flatMap(h => config.get("port").flatMap(p => Connection(h, p)))
    .map(c => c.connect)
    .foreach(println)

  val result0 = for {
    host <- config.get("host")
    port <- config.get("port")
    c <- Connection.apply(host, port)
  } yield c.connect

  result0.foreach(println)
}
