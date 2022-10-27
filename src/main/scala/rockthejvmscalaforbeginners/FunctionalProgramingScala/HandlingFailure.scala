package rockthejvmscalaforbeginners.FunctionalProgramingScala

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  /** La forma enque se usa el try es crear exito y freacaso explisitamente
    * Todo codigo puede generar un error no contemplado, por lo cual el manejo de errores es emblematico para que no se }detenga el aplicativo
    *  Se pudo trabajar con codigo breve u no el espagueti
    *
    *  Los mapas  y filtros  funcionan en las excepciones
    */

  val aSuccess = Success(3)
  val aFaliure = Failure(new RuntimeException("failure"))

  println(aSuccess)
  println(aFaliure)

  def fallando(): String = throw new RuntimeException("falla")
  val falloSeguro = Try(fallando())

  println(falloSeguro)

  /** No detiene el programa porque se capturo la exceocion
    * y como en todo scala esta el asucar sintactico de el manejo del error
    */
  val otrofalloSeguro = Try {
    // funcion con posibl eerrror
  }

  /** utilidades, puede validarse si alfuna funcion que tenga el bloque try  si es success
    */

  println(falloSeguro.isSuccess) // isFaliure

  def backupoMethod(): String = "Avalid Result"

  /** se peude definir que hacer en caso falle con un a funcion sin problema a fallar
    */
  val failBackTry = Try(fallando()).getOrElse(backupoMethod())
  println(failBackTry)

  /** Si al desarrollar se identifica que puede exister un fallo, definirlos por metodo / funcion
    */

  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("valido")
  val betterfail = betterUnsafeMethod() getOrElse betterBackupMethod()
  println(betterfail)

  /** para map flatmap y filter
    */
  println(aSuccess.map(_ * 5))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(
    aSuccess.filter(_ > 10)
  ) // encaso de no cumplir se convierte en excepcion

  /** *
    * Ejercicio
    */
  val host = "localhost"
  val port = "8080"

  def renderHTML(page: String) = println(page)
  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html> ---- </html>"
      else throw new RuntimeException("conexion interrumpida")
    }

    def getSeguro(url: String): Try[String] = Try(get(url))
  }
  object HttpService {
    val random = new Random(System.nanoTime())
    def getConection(host: String, port: String): Connection =
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("error de puerto??")

    def getconexionSeguro(host: String, port: String): Try[Connection] = Try(
      getConection(host, port)
    )
  }

  val possiblwConexion = HttpService.getconexionSeguro(host, port)
  val posibleHtml = possiblwConexion.flatMap(c => c.getSeguro("/home"))
  //posibleHtml.foreach(renderHTML)

  /** forma corta
    */

  HttpService
    .getconexionSeguro(host, port)
    .flatMap(c => c.getSeguro("/home"))
    .foreach(renderHTML)

  /** for compresion verison
    */
  for {
    conexion <- HttpService.getconexionSeguro(host, port)
    posibleHtml <- conexion.getSeguro("/home")
  } renderHTML(posibleHtml)

  /** internamente se veria de la siguiente forma
    * try{
    * conexion = - HttpService.getconexionSeguro(host, port)
    *  try{
    *  val page = conexion.get("/home")
    *  renderHteml(page)
    *  }catch(){}
    *  } catch(){}
    */
}
