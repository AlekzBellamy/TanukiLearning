package rockthejvmscalaforbeginners.FunctionalProgramingScala.exercises

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

    def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

    def fold[B](start: B)(operator: (B, A) => B): B

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

    def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
      if (!list.isEmpty) throw new RuntimeException(" no hay elementos")
      else EmptyList

    def fold[B](start: B)(operator: (B, Nothing) => B): B = start

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
      if (myPredicate0(h)) ConsList(h, t.filter(myPredicate0))
      else t.filter(myPredicate0)

    def foreach(f: A => Unit): Unit = {
      f(h)
      t.foreach(f)
    }
    def sort(f: (A, A) => Int): MyList[A] = {
      def insert(x: A, sortedList: MyList[A]): MyList[A] =
        if (sortedList.isEmpty) ConsList(x, EmptyList)
        else if (f(x, sortedList.head) <= 0) ConsList(x, sortedList)
        else ConsList(sortedList.head, insert(x, sortedList.tail))

      val sortedTail = t.sort(f)
      insert(h, sortedTail)
    }

    def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] =
      if (list.isEmpty) throw new RuntimeException(" no hay elementos3")
      else ConsList(zip(h, list.head), t.zipWith(list.tail, zip))

    /** como funciona
      * [1,2,3].fold(0)(+)
      * [2,3].fold(1)(+)
      * [3].fold(3)(+)
      * [].fold(6)(+)
      */
    def fold[B](start: B)(operator: (B, A) => B): B = {

      t.fold(operator(start, h))(operator)
    }

  }

  val listOfIntegers: MyList[Int] =
    ConsList(16, ConsList(21, ConsList(3, EmptyList)))
  val listOfIntegersClone: MyList[Int] =
    ConsList(1, ConsList(2, ConsList(3, EmptyList)))
  val listOfIntegers0: MyList[Int] =
    ConsList(10, ConsList(12, ConsList(13, EmptyList)))
  val listOfString: MyList[String] =
    ConsList("A", ConsList("B", ConsList("C", EmptyList)))
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

  listOfIntegers.foreach(println(_))
  println(
    listOfIntegers
      .sort((x, y) => y - x)
  )

  println(
    listOfIntegers.zipWith[String, String](listOfString, _ + " " + _)
  )

  println(listOfIntegersClone.fold(0)(_ + _))

  val g = for {
    nInt <- listOfIntegers
    string <- listOfString
  } yield (nInt.toString + string.toString)
  println(g)
}
