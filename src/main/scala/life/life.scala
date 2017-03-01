package life

object Life {
  type Generation = Set[(Int, Int)]

  def iterate(g: Generation): Generation = {
    for {
      row <- 0 until 1
      col <- 0 until 1
     } yield (row, col)

     g
  }
}
