package rockthejvmscalaforbeginners.FunctionalProgramingScala

object HOFsCurries extends App {

  /** analicemos algunas funciones
    *
    * La programacion funcional  trabaja con funciones
    * HOFs  se necesita pasar funciones como parametros o devolver funciones como resultado
    *
    * curriyfy se utiliza para generar subproductos/subfunciones/funciones precomplementarias,
    * y ademas trata con funciones , con multiples listas de parametros
    */

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) =
    null

  /** Esta funcion compleja se puede interpreta como
    * unca funcion con entrada de dos para metros
    * 1 er parametro un Int
    * 2 do parametro una funcion(que a su vez recibe 2 parametros 1 string y una funcion que retorna un booleano) que retornoa un int
    * 3ra como resultado una funcion que retorna un int
    */

  /** rememorizando una funcion de orden superior ,  se define asi porque toma o  retorna funciones
    */

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  def plusOne = (x: Int) => x + 1

  println(nTimes(plusOne, 10, 0))

  println(nTimes(((x: Int) => x + 1), 10, 0))

  def nTimes0(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimes0(f, n - 1)(f(x))

  /** la funcion anteriro se puede notar que tienen currify,por lo cual podemos implementar funfcines a media
    */
  val nTimes010 = nTimes0(plusOne, 10)
  println(nTimes010(0))
  println(nTimes0(plusOne, 10)(0))

  /** funciones curried
    * Int => Int => Int .....Int =>( Int => Int) se interpreta como un entero que retorna una funcion
    */

  val superAdd: Int => Int => Int = (x: Int) => (y: Int) => x + y

  /** esto nos permite crear funciones a media o premedidas el ejemplo de abajo se puede interpretar
    * = (3) => (y: Int) => x + y ..... un funcion por completar (y: Int) => 3 + y
    * son para generar ufunciones auxiliares
    * esto nos apoya a que se puedan preconfigurar las funciones y ser reutilizadas utilizando menos parametros
    */
  val add3 = superAdd(3)

  println(add3(10))
  println(superAdd(3)(10))

  def curriedFormarter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormarter("%4.2f")
  val precopormat: (Double => String) = curriedFormarter("%10.8f")

  /** cuando se utilice las semifunciones se tiene que especificar el tipo si no dara error
    * val standardFormat= curriedFormarter("%4.2f")  ERROR
    * val standardFormat: (Double => String) = curriedFormarter("%4.2f")
    */
  println(standardFormat(Math.PI))
  println(precopormat(Math.PI))

  /** Ejercicio
    * 1.- expandir MyList
    *    - foreach metodo que retorna Unit  A=> Unit
    *      [1,2,3].foreach(x=> print(x)) imprimira los valore
    *      -sort funcion paraordenar (A, A => Int) => MyList
    *      [12,3]. sort{x,y }=> y -x => [3,2,1]
    *      -ZipWith function  que toma otra lista para unirlas (list, (A, A) => MyList[B])
    *      [1,2,3].zipWith[4,5,6] , x* y= > [1* 4, 2* 5, 3* 6]
    *      -Fold(start)(function) => a vlaue
    *      [1,2,3].fold(0){x+y} = 6
    *
    * 2.-
    * toCurry(f: (Int, Int) = Int => (Int = Int = Int) que
    * fromCurry(f:Int => Int=> Int) = (Int,Int)=> Int
    * 3.-
    * compose(f,g) => x => f(g(x))
    * andThem(f,g) => x => g(f(x))
    */

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x, y) => f(x)(y)

  def compose(f: Int => Int, g: Int => Int): Int => Int =
    x => f(g(x))

  def andThen(f: Int => Int, g: Int => Int): Int => Int =
    x => g(f(x))

  /** para funcion X
    */
  def compose0[A, B, T](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def andThen0[A, B, C](f: A => B, g: B => C): A => C =
    x => g(f(x))

  def superAdder0: (Int => Int => Int) = toCurry(_ + _)

  val add4 = superAdder0(4)
  println(add4(6))

  def simpleAdder = fromCurry(superAdder0)

  println(simpleAdder(5, 5))

  val add20 = (x: Int) => x + 2

  val add30 = (x: Int) => x + 3

  val compose01 = compose0(add20, add30)
  val andThen01 = andThen0(add20, add30)

  println(add20)
  println(add30)
  println(compose01)
  println(andThen01)

  println(compose01(1))
  println(andThen01(4))
}
