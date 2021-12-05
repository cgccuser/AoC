//No real input, just stick the input into the input field at the bottom
object Main {
  def main(args: Array[String]) = {
    val lines = input.split("\n").map { case s"$x1,$y1 -> $x2,$y2" =>
      (x1.toInt, y1.toInt) -> (x2.toInt, y2.toInt)
    }
    val points = collection.mutable.HashMap[(Int, Int), Int]()
    for (((x1, y1) -> (x2, y2)) <- lines) {
      val newPoints =
        if (x1 == x2) y1.to(y2, (y2 - y1).sign).map((x1, _))
        else if (y1 == y2) x1.to(x2, (x2 - x1).sign).map((_, y1))
        else Seq.empty
      for (point <- newPoints) {
        points.put(point, points.getOrElse(point, 0) + 1)
      }
    }
    println(points.values.count(_ >= 2))
    println(points)
  }

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
