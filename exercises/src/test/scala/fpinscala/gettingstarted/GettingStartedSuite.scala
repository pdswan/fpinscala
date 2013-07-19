package test.scala.fpinscala

import org.scalatest.FunSuite

// vim: set ts=2 sw=2 et:

class GettingStartedSuite extends FunSuite {
  import fpinscala.gettingstarted.PolymorphicFunctions._

  def gtInt(x: Int, y: Int): Boolean = x > y
  def gtChar(x: Char, y: Char): Boolean = x > y

  test("binarySearch of Ints") {
    assert(binarySearch(Array(1, 2, 3), 3, gtInt) == 2)
  }

  test("binarySearch of Chars") {
    assert(binarySearch(Array('a', 'b', 'c', 'd'), 'd', gtChar) == 3)
  }

  test("isSorted on Ints") {
    assert(isSorted(Array(3, 2, 1), gtInt) == false)
    assert(isSorted(Array(1, 2, 3), gtInt))
  }

  test("partial1") {
    def atIndex(idx: Int, list: List[Int]): Int = list(idx)
    val partial = partial1(1, atIndex)
    assert(partial(List(1, 2)) == 2)
  }

  trait Currying {
    // A = Int, B = List, C = Int
    def toCurry(idx: Int, list: List[Int]): Int = list(idx)
    val curried = curry(toCurry)
  }

  test("curry") {
    new Currying {
      assert(curried(1)(List(3, 4)) == 4)
    }
  }

  test("uncurry") {
    new Currying {
      assert(uncurry(curried)(1, List(3, 4)) == 4)
    }
  }

  test("compose") {
    def g(x: Int): Int = x + 1
    def f(x: Int): String = x.toString
    val composed = compose(f, g)
    assert(composed(1) == "2")
    assert(composed(1) == f(g(1)))
  }
}
