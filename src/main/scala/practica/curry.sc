/** Currying en Scala es simplemente una técnica o un proceso de transformación de una función.
  * Esta función toma múltiples argumentos en una función que toma un solo argumento.
  * Se aplica ampliamente en múltiples lenguajes funcionales.
  */

/** Una HOF es sólo una función que toma una función como argumento o devuelve una función
  */
/** comunmente al utilizar curry se hace uso de closures
  */

def quadratic(a: Double, b: Double, c: Double, x: Double): Double =
  a * x * x + b * x + c
def quadFun(a: Double, b: Double, c: Double): Double => Double =
  x => quadratic(a, b, c, x) // closure --> cierre de funcon
val myQuad4 = quadFun(2, 1, 3)
println(myQuad4)
println(quadFun(1, 2, 3))

val curried_division: (Int) => (Int) => Option[Double] = { (x) => (y) =>
  if (y != 0)
    Some(x / y.toDouble)
  else
    None
}
println(curried_division)

def curried_division0(x: Int)(y: Int): Option[Double] = {
  if (y != 0)
    Some(x / y.toDouble)
  else
    None
}

println(curried_division0)
