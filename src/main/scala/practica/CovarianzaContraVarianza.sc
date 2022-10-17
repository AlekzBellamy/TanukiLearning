// Problematica/premisa => precisa que, en una relacion de herencia, un tipo definido como supertipo tiene que estar en un contexto que permita
// ser sustituid por cualquiera de sus clases derivadas en cualquier momento.

sealed abstract class Vehicle
case class Car() extends Vehicle
case class Motorcycle() extends Vehicle

val vehicleIdentity = (vehicle: Vehicle) => vehicle

vehicleIdentity(Car())

vehicleIdentity(Motorcycle())

// En los tipos genéricos, la varianza es la correlación que hay entre la relación de herencia de los tipos abstractos y cómo esta se «transmite» a la herencia en las clases genéricas.
//En otras palabras, dado una class Thing[A]:
//Si A hereda de B (A <: B), podemos decir que Thing[A] <: Thing[B] ?
//La varianza modela esta correlación y nos permite crear clases genéricas más reusables.
//
//Hay cuatro tipos de varianza: covarianza, contravarianza, invarianza y bivarianza,  tres de los cuales se plasman en Scala

//
//

/** Invarianza Parking[A]
  * Una clase genérica invariante sobre su tipo abstracto solo puede recibir un parameter type de exactamente ese tipo.
  * val p1: Parking[Vehicle] = Parking[Car](new Car)
  * El error lo deja claro, aunque Car <: Vehicle, debido a que Parking es invariante sobre A, Parking[Car] !<: Parking[Vehicle].
  */
case class ParkingInvariante[A](value: A)
val p1 = ParkingInvariante[Vehicle](new Motorcycle)
p1.value.getClass

/** Covarianza Parking[+A]
  * Una clase genérica covariante sobre su tipo abstracto puede recibir un parameter type de ese tipo o subtipos de ese tipo.
  * La covarianza permite tipar p1 como Parking[Vehicle] y asignarle un Parking[Car].
  * Pero no hay que olvidar que aunque p1 esté tipado como Parking[Vehicle], en realidad es un Parking[Car],
  * esto puede ser confuso, pero más abajo explico que son las posiciones co/contravariantes y se entiende todo.
  * For Parking[+A]
  * If Car <: Vehicle
  * Then Parking[Car] <: Parking[Vehicle]
  */

case class ParkingCovariante[+A](value: A)
val p2: ParkingCovariante[Vehicle] = ParkingCovariante[Car](new Car)

/** Contravarianza Parking[-A]
  * Una clase genérica contravariante sobre su tipo abstracto puede recibir un parameter type de ese tipo o supertipos de ese tipo.
  * La contravarianza nos permite tipar p1 como Parking[Car] y asignarle un Parking[Vehicle]
  * For Parking[-A]
  * If Vehicle >:(supertype of) Car
  * Then Parking[Vehicle] <: Parking[Car]
  */

class ParkingContraVarianza[-A]
val p3: ParkingContraVarianza[Car] = ParkingContraVarianza[Vehicle]

/** Un tipo puede estar en posición coovariante o contravariante según dónde esté especificado. Algunos de los ejemplos más claros son los siguientes:
  */
abstract class Animal() {}

case class Cat() extends Animal {}
case class Dog() extends Animal {}

case class Pets[+A](val pet: A) {
  // def add(pet2: A): String =
  // "done" //covariant type A occurs in contravariant position in type A of parameter pet2
}
// ese mensaje de eror hace que  o limita auqe mascotas sea solo gatos o  solo perros, y noo se convinen , obvio animal puede tener mas subtipos
// define que  mascota es un Pets[Cat] y add() solo puede aceptar Cats o subtipo de Cat. y el compilador nos da el errorp
// para evidar add funcione con otro tipo de animal
val mascotas: Pets[Animal] = Pets[Cat](new Cat)

class Pets0[-A](val pet: A)
//contravariant type A occurs in covariant position in type A of value pet
val mascotas0: Pets0[Cat] = Pets0[Animal](
  new Animal
) //El compilador se esperaría que mascotas.pet fuese de tipo Cat y pudiese hacer mascotas.pet.meow(), pero mascotas.pet no es Cat, es Animal.

val mascotas1: Pets[Animal] = Pets[Cat](
  new Cat
) //el compilador esperará que mascotas.pet sea de tipo Animal, y debido a que Cat <: Animal, lo es.
