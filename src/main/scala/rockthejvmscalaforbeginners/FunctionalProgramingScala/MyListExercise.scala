package rockthejvmscalaforbeginners.FunctionalProgramingScala

object MyListExercise extends App {
  abstract class MyList[+A] {
    def head: A

    def tail: MyList[A]

    def isEmpty: Boolean

    def add[B >: A](element: B): MyList[B]

    def printElements: String

    override def toString: String = "[" + printElements + "]"

    /** ahora son funciones de orden superrior , higer- order functrion
      * ahora  como parametros se usan funciones como valores de primer orden o devuelven  otras funciones
      */
    def map[B](transformer: A => B): MyList[B]

    def flatMap[B](transformer: A => MyList[B]): MyList[B]

    def filter(myPredicate0: A => Boolean): MyList[A]

    //def flatMap[B](f:)
    def ++[B >: A](list: MyList[B]): MyList[B]

    //HOGS
    def foreach(f: A => Unit): Unit

    def sort(f: (A, A) => Int): MyList[A]

    /*def zipWith[B](f: (A, A) => B): MyList[B]*/

  }

  case object EmptyList extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException()

    def tail: MyList[Nothing] = throw new NoSuchElementException()

    def isEmpty: Boolean = true

    def add[B >: Nothing](element: B): MyList[B] =
      new ConsList(element, EmptyList)

    def printElements: String = ""

    def map[B](transformer: Nothing => B): MyList[B] = EmptyList

    def flatMap[B](
        transformer: Nothing => MyList[B]
    ): MyList[B] = EmptyList

    def filter(myPredicate0: Nothing => Boolean): MyList[Nothing] = EmptyList

    def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

    def foreach(f: Nothing => Unit): Unit = ()

    def sort(f: (Nothing, Nothing) => Int) = EmptyList
  }

  case class ConsList[+A](h: A, t: MyList[A]) extends MyList[A] {
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
    def map[B](transformer: A => B): MyList[B] =
      new ConsList(transformer(h), t.map(transformer))

    /** como trabaja
      * [1,2].flatmap(n=> [n,n+1])
      * = [1,2] ++ [2].flatmap(n=> [n,n+1])
      * = [1,2] ++ [2,3] ++ [].flatmap(n=> [n,n+1])
      * = [1,2] ++ [2,3] ++ empty
      * = [1,2,2,3]
      */
    def flatMap[B](transformer: A => MyList[B]): MyList[B] =
      transformer(h) ++ t.flatMap(transformer)

    /** como trabaja
      * [1,2] ++ [3.,5,6]
      * new Cons(1, [2] ++ [3,4,5])
      * new Cons(1, new Cons(2 [] ++ [3,4,5]))
      * new Cons(1, new Cons(2 new Cons(3,new Cons(4, new Cons(5, empty)))))
      *
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
      * new Cons(2, [3].filter(n%2 ==0 false)) =>  new Cons(2, [].filter(n%2 ==0))
      * new Cons(2, empty)
      */
    def filter(myPredicate0: A => Boolean): MyList[A] =
      if (myPredicate0(h)) new ConsList(h, t.filter(myPredicate0))
      else t.filter(myPredicate0)

    def foreach(f: A => Unit): Unit = {
      f(h)
      t.foreach(f)
    }
    def sort(f: (A, A) => Int): MyList[A] = {
      def insert(x: A, sortedList: MyList[A]): MyList[A] = {
        if (sortedList.isEmpty) new ConsList(x, EmptyList)
        else if (f(x, sortedList.head) <= 0) new ConsList(x, sortedList)
        else new ConsList(sortedList.head, insert(x, sortedList).tail)
      }

      val sortedTail = t.sort(f)
      insert(h, sortedTail)
    }
  }

  val listOfIntegers: MyList[Int] =
    new ConsList(1, new ConsList(2, new ConsList(3, EmptyList)))
  val listOfIntegersClone: MyList[Int] =
    new ConsList(1, new ConsList(2, new ConsList(3, EmptyList)))
  val listOfIntegers0: MyList[Int] =
    new ConsList(10, new ConsList(12, new ConsList(13, EmptyList)))
  val listOfString: MyList[String] =
    new ConsList("A", new ConsList("B", new ConsList("C", EmptyList)))
  println(
    listOfIntegers.map(elem => elem * 2).toString
  )
  println(
    listOfIntegers.map(_ * 2).toString
  )
  println(
    listOfIntegers
      .filter(elem => elem % 2 == 0)
      .toString
  )
  println(
    listOfIntegers
      .filter(_ % 2 == 0)
      .toString
  )

  println(
    listOfIntegers
      .flatMap(elem => new ConsList(elem, new ConsList(elem + 1, EmptyList)))
      .toString
  )
  //val add0: (Int, Int) => Int = _ + _ // (a,b) >= a+b
  val myFunction0: (Int => Int => Int) = x => y => x + y
  println(myFunction0(1)(3))
  val myFunction: Function1[Int, Function1[Int, Int]] =
    new Function1[Int, Function1[Int, Int]] {

      override def apply(x: Int): Int => Int = new Function1[Int, Int] {
        override def apply(y: Int): Int = x + y
      }
    }
  println(myFunction(1)(3))

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(1)(3))

  listOfIntegers.foreach(print(_))

}
