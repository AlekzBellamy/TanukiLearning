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
