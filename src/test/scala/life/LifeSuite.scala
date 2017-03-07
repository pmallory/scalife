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

  test("a cell in an empty generation has no neighbors") {
    assert(neighborCount((1,2), Set()) === 0)
  }

}
