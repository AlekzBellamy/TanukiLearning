package rockthejvmscalaforbeginners.absolutescalabasics

object CallByNameCallByValue extends App {

  /** una funcion  de llamana por valor
    * El valor es el evaluado
    * El valor pasado a la función es realmente el usado dentro, no importa las veces que se usa, sera el mismo valor
    */

  def calledByValue(x: Long): Unit = {
    println("calledByValue " + x)
    println("calledByValue " + x)
  }

  /** una funciom de llavada por nombre
    * La expresión es la evaluada, es como si  la variable este actualizandoce en todo momento/ o accediera a la informacion mas actual de esa variable
    * , esto permitira tener su valor  actual
    * Es util en transmisiones perezosas
    * La expresion es usada cada vez que se usa
    */

  def calledByName(x: => Long): Unit = {
    println("calledByName " + x)
    println("calledByName " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  /** El siguiente ejercicio o funcion es una truco trick, para  manejar algun proceso que podria colapsar  por unsa recursion infinita
    */

  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: => Int) = println(x)

  def printFirst0(x: Int, y: => Int) = println(y)

  //El ejemplo anterior  donde  la funcion infinite esta incrementeand0 hasta el desbordamiento se pasa  en una llamada por valor y  sale error
  //printFirst(infinite(), 34);
  // Sin embargo si se pasa   el infinito(el metodo que puede colapsar) en un parametro de llamada por nombre, permite continuar y no dar error D=
  // NOTA => Debido a que el parametro "y" no se usa en printFirst el programa continua
  printFirst(
    34,
    infinite()
  ) /// cuando se use parametro por llamada el infinite causara error  hasta ser llamado
  // Se probo  el infinii el x y no usarlo con en el ejemoplo anterior y da error
  //printFirst0(infinite(), 34) // per en este caso cuando se use  el parametro por valor  el infinite causa el el desbordamiento

}
