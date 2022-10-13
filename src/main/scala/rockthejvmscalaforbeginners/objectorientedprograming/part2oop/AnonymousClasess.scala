package rockthejvmscalaforbeginners.objectorientedprograming.part2oop

object AnonymousClasess extends App {

  /** Clases Anonimas
    */

  abstract class Animal {
    def eat: Unit = println(s"comer comer")
  }

  /** en el siguiente ejemplo se logra hacer una instancia de clase abstracta y  se sobreescribe el metodo eat
    * Internamente, el compilador crea una clase real $$....$1
    *
    * Instancia de clase anonima val cualquierAnimal: Animal = new Animal....
    *  se deben respetar los parametros de clase
    *  si estas instanciando una clase anonima que desciende de un tipo de datos abstractos como una clase abstracta o
    *  una operacion que necesita para implementar todos los metdps o campos abstractos, solo debes saber quie las clases anonimas solo funcionan para rascos y cases que sean abstractos o no
    */

  val cualquierAnimal: Animal = new Animal {
    override def eat: Unit = println(s" hambre hambre")
  }
  val cualquierAnimal0: Animal = new Animal {
    override def eat: Unit = println(s" hambre hambre")
  }

  /** class rockthejvmscalaforbeginners.objectorientedprograming.part2oop.AnonymousClasess$$anon$1
    */
  println(cualquierAnimal.getClass)

  /** class rockthejvmscalaforbeginners.objectorientedprograming.part2oop.AnonymousClasess$$anon$2
    */
  println(cualquierAnimal0.getClass)

  /** Este paso se llama anonimous class, el compilador crea una clase real conun nombre $$anon$numero, numero es el numero de lcase anonimo creada
    * ahora practicamente el compilador  genera una clase anonima con un extends por ejemplo con Animal
    * class rockthejvmscalaforbeginners.objectorientedprograming.part2oop.AnonymousClasess$$anon$2 extends Animal
    */

  class Person(name: String) {
    def sayHi: Unit = println(s"hola, soy ${name}, te puedo ayudar?")
  }

  val alekz = new Person("") {
    override def sayHi: Unit = println(
      "hola, soy alekz, me puedo ayudar--?> te puedo?"
    )
  }

  /** 1 .- Crear una rasgo Generico T llamado MyPredicate[-T] y tendra un metodo para probar si un valor de tipo T pasa una condicion
    *    Entonces  cada subclase de mi equipo predicado realmente tendra una implem,entacion diferente de es epequeño metodo que prueba si para T esa condifiocn
    * 2.- Crear un rasgo generico llamado mi transofmrador MyTransformrr[-A,B] , el cual tomara dos parametros y tendra  un pequeño metodo para convertir
    *      un cvalor de tipo en un valor A a un valor de tipo B, clada subclase de mi transformador tendra una implementacion diferente de ese metodo
    *  3.- Agregar en MyList las siguientes funciones, una funcion llamada map y pase por parametro transformer y devielve una nueva lista de un filtro de tipo diferente que toma mi predicado
    *    map(transformer) => MyList
    *    Agregar  filter
    *    filter(MyPredicate) => MyList
    *    flatMap(tranformer from A to MyList[B]) => MyList[B]
    *    Ademas impementar
    *    class EventPredicate exends MyPredicate[Int]
    *    class StringToIntTranformer extedns MyTransformes[String, Int]
    *
    *    otro metodo para probvar es
    *    [1,2,3]. Map (n*2)= [2,4,6]
    *    [1,2,3,4]. filter (n%2) = [2,4]
    *    [1,2,3]. flatMap => [n,n+1] => [1,2,2,3,3,4]
    *
    *    utilizar la contravariante -T y -A
    */
  trait MyPredicate0[-T] {
    def test[T](f: T => Boolean): Boolean
  }

  trait MyPredicate[-T] {
    def test(elem: T): Boolean
  }
  trait MyTransformer0[-A, -B] {
    def transform[A, B](f: A => B): B
  }

  trait MyTransformer[-A, B] {
    def transform(elem: A): B
  }

  abstract class MyList[+A] {
    def head: A

    def tail: MyList[A]

    def isEmpty: Boolean

    def add[B >: A](element: B): MyList[B]

    def printElements: String

    override def toString: String = "[" + printElements + "]"

    def map[B](transformer: MyTransformer[A, B]): MyList[B]

    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
    def filter(myPredicate0: MyPredicate[A]): MyList[A]
    //def flatMap[B](f:)
    def ++[B >: A](list: MyList[B]): MyList[B]
  }

  object EmptyList extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException()

    def tail: MyList[Nothing] = throw new NoSuchElementException()

    def isEmpty: Boolean = true

    def add[B >: Nothing](element: B): MyList[B] =
      new ConsList(element, EmptyList)

    def printElements: String = ""

    def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = EmptyList

    def flatMap[B](
        transformer: MyTransformer[Nothing, MyList[B]]
    ): MyList[B] = EmptyList

    def filter(myPredicate0: MyPredicate[Nothing]): MyList[Nothing] = EmptyList
    def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  }

  class ConsList[+A](h: A, t: MyList[A]) extends MyList[A] {
    def head: A = h

    def tail: MyList[A] = t

    def isEmpty: Boolean = false

    def add[B >: A](element: B): MyList[B] = new ConsList(element, this)

    def printElements: String =
      if (t.isEmpty) "" + h
      else "" + h + t.printElements + ""

    /** como trabaja el map
      * [1,2,3].map( n*2)
      * = new Cons(2, [2,3].map( n*2))
      * = new Cons(2, new Cons(4, [3].map( n*2)))
      * = new Cons(2, new Cons(4, new Cons(6, [].map( n*2))))
      * = new Cons(2, new Cons(4, new Cons(6, empty)))
      */
    def map[B](transformer: MyTransformer[A, B]): MyList[B] =
      new ConsList(transformer.transform(h), t.map(transformer))

    /** como trabaja
      * [1,2].flatmap(n=> [n,n+1])
      * = [1,2] ++ [2].flatmap(n=> [n,n+1])
      *  = [1,2] ++ [2,3] ++ [].flatmap(n=> [n,n+1])
      *   = [1,2] ++ [2,3] ++ empty
      *    = [1,2,2,3]
      */
    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
      transformer.transform(h) ++ t.flatMap(transformer)

    /** como trabaja
      * [1,2] ++ [3.,5,6]
      * new Cons(1, [2] ++ [3,4,5])
      * new Cons(1, new Cons(2 [] ++ [3,4,5]))
      *  new Cons(1, new Cons(2 new Cons(3,new Cons(4, new Cons(5, empty)))))
      * @param list
      * @tparam B
      * @return
      */
    def ++[B >: A](list: MyList[B]): MyList[B] =
      new ConsList(h, t ++ list)

    /** como trabaja el filter
      * [1,2,3]. filter (n%2 ==0)=
      * [2,3].filter(1%2==0 false) =>  [2,3]. filter (n%2 ==0)=
      * [3].filtert(2%2==0 true) => new Cons(2, [3].filter(n%2 ==0))
      *  new Cons(2, [3].filter(n%2 ==0 false)) =>  new Cons(2, [].filter(n%2 ==0))
      *  new Cons(2, empty)
      */
    def filter(myPredicate0: MyPredicate[A]): MyList[A] =
      if (myPredicate0.test(h)) new ConsList(h, t.filter(myPredicate0))
      else t.filter(myPredicate0)
  }
  val listOfIntegers: MyList[Int] =
    new ConsList(1, new ConsList(2, new ConsList(3, EmptyList)))
  val listOfIntegers0: MyList[Int] =
    new ConsList(10, new ConsList(12, new ConsList(13, EmptyList)))
  val listOfString: MyList[String] =
    new ConsList("A", new ConsList("B", new ConsList("C", EmptyList)))
  println(
    listOfIntegers
      .map(new MyTransformer[Int, Int] {
        override def transform(elem: Int): Int = elem * 2
      })
      .toString
  )

  println(
    listOfIntegers
      .filter(new MyPredicate[Int] {
        override def test(elem: Int): Boolean = elem % 2 == 0
      })
      .toString
  )

  println(
    listOfIntegers ++ listOfIntegers0
  )

  println(
    listOfIntegers
      .flatMap(new MyTransformer[Int, MyList[Int]] {
        override def transform(elem: Int): MyList[Int] =
          new ConsList(elem, new ConsList(elem + 1, EmptyList))
      })
      .toString
  )
//KLista  covariante
}
