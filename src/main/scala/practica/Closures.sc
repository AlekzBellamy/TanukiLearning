/** Un Closure es aquella función que hereda el contexto de otra función con lo cual permite heredar las variables utilizadas en la primera.
  * No hay que confundir un closures con el concepto de función anónima.
  */

val factor = 2

def suma1(x: Int) = x + factor
println(suma1(2))
def funcionXXXX(x: Int, y: Int, f: Int => Int => Int): Int = {
  f(x)(y)
}

println(funcionXXXX(2, 3, x => y => x + y))

val suma: Int => Int => Int = (x: Int) => (y: Int) => x + y

val suma5 = suma(5)
// esta funciona anonima parece a un closure debido a que trae preconfigurado el primer valor de la
// suma lo cal  la siguiente implementacion de esta funcion es complementar el faltante de numero
// para ejecutar la suma
println(suma5)
println(suma5(6))


