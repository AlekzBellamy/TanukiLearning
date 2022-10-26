// probably in a library
class Prefixer(val prefix: String)
def addPrefix(s: String)(implicit p: Prefixer) = p.prefix + s

// then probably in your application
implicit val myImplicitPrefixer: Prefixer = new Prefixer("***")
addPrefix("abc") // returns "***abc"

def x(implicit a: Int) = a

implicit val z: Int = 10

x // compiler will use implicit like this x(z)
println(x)

val i = 1
val intaddition = Seq(i).map { n => n + 1 }
println(intaddition)

implicit def intToSeq(i: Int): Seq[Int] = Seq(i)
println(i + 10)
println(i.map(_ + 2))

def findAnInt(implicit x: Int) = x
//findAnInt: (implicit x: Int)Int
findAnInt(1)

findAnInt
