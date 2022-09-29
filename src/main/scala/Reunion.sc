
val x = 1;

def prueba(): Unit = {
  val x = 2;
  println(x)
}
prueba


  def suma(x:Int, y :Int ): Int =
  {
    x + y
  }
  def resta(x: Int, y: Int): Int = {
    x - y
  }

  //inpura
  def resta2(x: Int)( y: Int): Int = {
    resta(x,y)
  }

  def op2(x: Int, y: Int, f: ( Int => Int => Int)): Int = {

    f(x)( y)
  }

  def op(x: Int, y: Int, f: (Int, Int) => Int): Int = {
    f(x, y)
  }

  def op3(x: Int)( y: Int)(  f: (Int => Int => Int)): Int = {
    f(x)(y)
  }

  op2(1,2,resta2)

val r = resta2(5)_
r(2)
r(1)
r(210)

val g = resta2(_)(_)
g









