package life

object Life {
  type Generation = Set[(Int, Int)]

  def iterate(g: Generation, dims:(Int, Int)): Generation = {
    val cells = for { row <- 0 until dims._1
                      col <- 0 until dims._2
                    } yield (row, col)

    // TODO: this should be a filter with a "living" func
    (for { c <- cells
          if !g.contains(c) && neighborCount(c, g) == 3 ||
          g.contains(c) && (neighborCount(c, g) == 2 || neighborCount(c, g) == 3)
        } yield c).to[Set]
  }

  def neighborCount(coord: (Int, Int), g: Generation): Int = {
   (for {
      row <- (coord._1 - 1) to (coord._1 + 1)
      col <- (coord._2 - 1) to (coord._2 + 1)
      if (row, col) != coord && g.contains((row, col))
    } yield (row, col)).length
  }

}
