object Main {
  def main(args: Array[String]) = {
    val lines = input.split("\n").map { case s"$x1,$y1 -> $x2,$y2" =>
      (x1.toInt, y1.toInt) -> (x2.toInt, y2.toInt)
    }
    val points = collection.mutable.HashMap[(Int, Int), Int]()
    for (((x1, y1) -> (x2, y2)) <- lines) {
      val newPoints =
        if (x1 == x2) range(y1, y2).map((x1, _))
        else if (y1 == y2) range(x1, x2).map((_, y1))
        else range(x1, x2).zip(range(y1, y2))
      for (point <- newPoints) {
        points.put(point, points.getOrElse(point, 0) + 1)
      }
    }
    println(points.values.count(_ >= 2))
  }
  
  def range(n1: Int, n2: Int) = n1.to(n2, (n2 - n1).sign)

  val input = """0,9 -> 5,9
8,0 -> 0,8
9,4 -> 3,4
2,2 -> 2,1
7,0 -> 7,4
6,4 -> 2,0
0,9 -> 2,9
3,4 -> 1,4
0,0 -> 8,8
5,5 -> 8,2"""
}
