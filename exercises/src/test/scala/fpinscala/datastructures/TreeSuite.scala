package fpinscala.datastructures

import org.scalatest.FunSuite

// vim: set ts=2 sw=2 et:

class TreeSuite extends FunSuite {
  test("size") {
    assert(Tree.size(Leaf(1)) == 1)
    assert(Tree.size(Branch(Leaf(1), Leaf(2))) == 2)
    assert(Tree.size(Branch(Leaf(1), Branch(Leaf(2), Leaf(3)))) == 3)
  }

  test("max") {
    assert(Tree.max(Leaf(1)) == 1)
    assert(Tree.max(Branch(Leaf(1), Leaf(2))) == 2)
    assert(Tree.max(Branch(Leaf(8), Branch(Leaf(1), Leaf(5)))) == 8)
  }

  test("depth") {
    assert(Tree.depth(Leaf(1)) == 0)
    assert(Tree.depth(Branch(
      Branch(Leaf(1), Leaf(2)), Leaf(3)
    )) == 2)
  }

  def addOne(x: Int) = x + 1

  test("map") {
    assert(Tree.map(Leaf(1), addOne) == Leaf(2))
    assert(
      Tree.map(Branch(Leaf(1), Branch(Leaf(2), Leaf(3))), addOne) ==
      Branch(Leaf(2), Branch(Leaf(3), Leaf(4)))
    )

  }
}
