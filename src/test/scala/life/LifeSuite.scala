package life

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Life._

@RunWith(classOf[JUnitRunner])
class LifeSuite extends FunSuite {
  test("the generation following an empty generation is empty") {
    assert(iterate(Set(), (1,2)) === Set())
  }
  test("the generation following a one-cell generation is empty") {
    assert(iterate(Set((0,0)), (1,2)) === Set())
  }

  test("a cell in an empty generation has no neighbors") {
    assert(neighborCount((1,2), Set()) === 0)
  }
  test("a cell is not its own neighbor") {
    assert(neighborCount((1,2), Set((1,2))) === 0)
  }
  test("a cell with one neighbor") {
    assert(neighborCount((1,2), Set((1,2), (2,2))) === 1)
  }
  test("a cell with eight neighbors") {
    assert(neighborCount((1,1), Set((0,0), (0,1), (0,2),
                                    (1,0), (1,1), (1,2),
                                    (2,0), (2,1), (2,2)))
           === 8)
  }

}
