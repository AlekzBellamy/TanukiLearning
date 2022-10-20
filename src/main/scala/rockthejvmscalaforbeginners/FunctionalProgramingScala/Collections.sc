/** Existen colecciones mutables e inmutables, las inmutables son por defecto en el uso de scala
  *
  * Traversable es  la madre de todas la colecciones
  *
  *                                  Traversable INMUTABLE
  *                                      |
  *                                  Iterable
  *                   |                  |                        |
  *                 Set                Seq                       Map
  *               |    |            |       |                  |          |
  *         HashSet  SortedSet  IndexSeq    LinearSeq     HashMap        SortedMap
  *                               /  |  \           \
  *                             /    |   \            \
  *                        Vector  String  Range       List Streams  Stacks    Queue
  *
  *                                     Traversable   MUTABLE
  *                                      |
  *                                  Iterable
  *                   |                  |                                              |
  *                 Set                Seq                                            Map
  *               |    |            |    |         \                            |          |
  *       HashSet  LinkedHS  IndexSeq    buffer      LinearSeq             HashMap        MultiMap
  *                           /  |  \          |                \
  *                         /    |   \   arraybuffer lsit buffer  \
  *                     Vector  String  Range             LinkedList   mutable List
  */
/** Como se puede ver Traversables es  la madre de las colecciones y esto ofrece
  * maps
  * conversions
  * size info
  * test
  * filds
  * retrieval
  * StringOps
  */
