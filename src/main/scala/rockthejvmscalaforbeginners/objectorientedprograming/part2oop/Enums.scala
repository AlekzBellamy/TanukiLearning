package rockthejvmscalaforbeginners.objectorientedprograming.part2oop

object Enums extends App {

  /** Los enums son un tipo de datos que se puede definir como clase,(informacion predefinida/constantes nombrados de tipo)
    * Crea instancias/ y estas seran unicas posibles de usar con un caso de palabraclaves/ es decir instancias de solo lectura
   *
   * permite agregar campos y metodos
    */

  enum Permissions{
    case READ, WRITE, EXECUTE , NONE

    def openDocument(): Unit=
    if(this==READ) println("documento abierto")
    else println("lectura no permitida")
   }

  /**
   * la forma de impelementar/usat/instanciar seria la siguiente
   */
  val somePermissions: Permissions= Permissions.READ

  println(somePermissions)

  somePermissions.openDocument()

  /**
   * los enums pueden definir constantes
   */

  enum PermissionWithBits(bits: Int){
    case READ extends PermissionWithBits(4)
    case WRITE extends PermissionWithBits(2)
    case EXECUTE extends PermissionWithBits(1)
    case NONE extends PermissionWithBits(0)
    
  }

  /**
   * SE Puede mejorar el uso de los enums con  objetos complementario para que el enum tenga como fuente  para los metodos de fabrica
   */
  object PermissionWithBits{
    def valida():PermissionWithBits = PermissionWithBits.READ
  }

  /**
   * una de las funciones es la capacidad de inspeccionar el indice u ordinal, en el que se definio ese permiso particular
   * es decir se puede obtener la posicion  del item del enumusado
   */

  val sp = somePermissions.ordinal

  /**
   * tiene la capacidad de iterar  o hacerse de los valores posibles del enum
   */

  val allPermission = PermissionWithBits.values
  println(allPermission)

  val readPermission : Permissions = Permissions.valueOf("READ")
  println(readPermission)

}
