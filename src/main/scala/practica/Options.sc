val list1 = List(Some(1), None, None, Some(2))

list1.flatten

list1.flatMap(_.map(_ + 1))
list1.collect { case Some(x) =>
  x + 1
}

list1.fold(Option(0)){
  (rs,x) =>
    for(n <- x;
        m <- rs
        )
    yield {n+m}
}