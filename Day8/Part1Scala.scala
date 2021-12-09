object Main {

  /** The number of segments needed for each digit */
  val numSegments = Map(
    0 -> 6,
    1 -> 2,
    2 -> 5,
    3 -> 5,
    4 -> 4,
    5 -> 5,
    6 -> 6,
    7 -> 3,
    8 -> 7,
    9 -> 6
  )

  def main(args: Array[String]) = {
    val lines = io.Source.fromFile("input.txt").getLines
    println(lines.map { case s"$signals | $digits" =>
      digits
        .split(" ")
        .map(_.size)
        .count(x => x == 2 || x == 4 || x == 3 || x == 7)
    }.sum)
  }
}
