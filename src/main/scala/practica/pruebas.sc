//funciones anonimas ??? conociendo
def prueba(x: => Int) = {
  x * x
}

def suma(x: Int, y: Int): Int = x + y
def cuadrado(x: Int): Int = x * x

prueba(suma(2, 6))
prueba(cuadrado(2))

/// curring

def multiplicar(no1: Int)(no2: Int): Int = no1 * no2
println(multiplicar(1)(2))

def multiplicadorPrevio(n: Int) = multiplicar(n)(2)

println(multiplicadorPrevio(10))
val donuts: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
val donutPrices: Seq[Double] = Seq(1.5, 2.0, 2.5)

donuts zip donutPrices

// se zipea por posicion , el problema es que la tupla que no sea tupla no se cuenta

/** The elements of the resulting zipped collections are tuples with donut names along with their corresponding prices.
  * Los elementos de las colecciones comprimidas resultantes son tuplas con nombres de anillos junto con sus precios correspondientes.
  */
val donuts0: Seq[String] =
  Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
val donutPrices0: Seq[Double] = Seq(1.5, 2.0)

donuts0 zip donutPrices0
