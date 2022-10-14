//FLATMAP es  identico a map , pero la diferencia es que flatmap elimina la agrupacion interna de un elemento  y genera su secuencia
//muy util para cuando  extraemos informacion de listas de listas y queremos tener solo el resultado en una lista,
// es nuna  fusion de map y aplanar, el resultado obtenido es la ejecucion del metodo map y enseguida el flatten
// NOTA, tiene una clase de ob opcion incorporada ,  el metodo flatten se utiliza para desintegrar los elementos
// de una colexxion Scala con el fin de construir una  unoca coleccion

val x = Seq("ale", "medina")

x.map(_.toUpperCase).flatten
x.flatMap(_.toUpperCase)

val x0 = Seq(Seq("ale"), Seq("medina"))

x0.flatMap(_.map(_.toUpperCase()))
x0.flatten.map(_.toUpperCase())

val x1 = Seq(5, 15)
x1.flatMap(s => Seq(s, s * 10))

val seq = Seq(8, 15, 22, 23, 24)
seq.flatMap { s =>
  if (s % 3 == 0) Seq(s)
  else Seq(-s)
}

val g = 6 / 1
