/** Que es la programacion funcional?
  *
  *  toda función es un valor
  *  funciones anónimas
  *  funciones de orden superior,
  *  funciones anidadas}
  *  currying
  */

/** Scala permite la definición de funciones de orden superior.
  * Estas funciones son las que toman otras funciones como parámetros, o las cuales el resultado es una función
  */

def funcion0(f: Int => String, valor2: Int) = f(valor2)
println(funcion0)
funcion0((x: Int) => "hola " + x, 1)

val funcionAnonima = (name: String) => println(s"""hola ${name}""")
println(funcionAnonima)
println(funcionAnonima(" ale"))

def funcion1(f: String => String, name: String) = f(name)
println(funcion1)

val myFunction1 = new Function1[Function1[String, String], String] {
  override def apply(a: String => String): String = {
    a.apply("pepe")
  }
}
println(myFunction1)
