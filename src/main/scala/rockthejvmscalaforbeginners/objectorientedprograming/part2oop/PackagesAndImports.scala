package rockthejvmscalaforbeginners.objectorientedprograming.part2oop

import practica.Cinderella
import rockthejvmscalaforbeginners.objectorientedprograming.exercises.Writer

object PackagesAndImports extends App {

  val writer = new Writer("", "", 1)

  val cinderella = new Cinderella

  /** Hay package Objects, para no  acceder a alguna clase, este nos permite a usar metodos lml(meme que se repita)
    *
    * sayHola viene de otro lado (un objeto definido como package) y este puede ser accedido desde cualquier clase u object dentro del mismo paquete
    *
    * Se pueden renombrar las clases de los import
    * package.{ClassA => RenameClassA}
    *
    * Cuando se importan de diferentes paquetes algunas clases con el mismo nombre, slca lo permite sin embargo a quien toma caso
    * es al primer impor
    * java.util.Date ==> priorida al implem,entar
    * java.sql.Date --> es prefefirble usar el nombre compreto de paquete y clase en su uso oo renombrarla lml
    */

  println(sayHola())
}
