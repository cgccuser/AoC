object Main {

  val segments = List("cagedb", "ab", "fbcad", "eafb", "cdfbe", "cdfgeb", "dab", "acedgfb", "cefabd")

  def main(args: Array[String]) = {
    val lines = io.Source.fromFile("test_input.txt").getLines
    println(lines.map { case s"$signals | $digits" =>
      digits.split(" ").map { d =>
        val ds = d.toSet
        segments.indexWhere(_.toSet == ds)
      }.foldLeft(0)(10 * _ + _)
    }.sum)
  }
}
