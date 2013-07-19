package fpinscala.datastructures

import org.scalatest.FunSuite

// vim: set ts=2 sw=2 et:

class ListSuite extends FunSuite {
  val l = List(1, 2)

  test("tail") {
    assert(List.tail(l) == List(2))
    assert(List.tail(List.tail(l)) == Nil)
  }

  test("drop") {
    assert(List.drop(Nil, 1) == Nil)
    assert(List.drop(l, 1) == List(2))
    assert(List.drop(l, 2) == Nil)
  }

  test("dropWhile") {
    assert(List.dropWhile(l)(_ < 2) == List(2))
    assert(List.dropWhile(l)(_ < 3) == Nil)
    assert(List.dropWhile(l)(_ < 1) == List(1, 2))
  }

  test("setHead") {
    assert(List.setHead(Nil)(5) == List(5))
    assert(List.setHead(l)(4) == List(4, 2))
  }

  test("init") {
    assert(List.init(Nil) == Nil)
    assert(List.init(List(1, 2, 3, 4)) == List(1, 2, 3))
  }

  test("length") {
    assert(List.length(Nil) == 0)
    assert(List.length(List(1, 2, 3)) == 3)
    assert(List.length(List(1, 2, 3, 4)) == 4)
  }

  test("foldLeft") {
    assert(List.foldLeft(List(1, 2, 3), 0)(_ + _) == 6)
    assert(List.foldLeft(List('a', 'b', 'c'), "")(_ + _) == "abc")
  }

  test("foldRightViaFoldLeft") {
    assert(List.foldRightViaFoldLeft(List(1, 2, 3), 0)(_ + _) == 6)
    assert(List.foldRightViaFoldLeft(List('a', 'b', 'c'), "")(_ + _) == "abc")
  }

  test("foldLeftViaFoldRight") {
    assert(List.foldLeftViaFoldRight(List(1, 2, 3), 0)(_ + _) == 6)
    assert(List.foldLeftViaFoldRight(List('a', 'b', 'c'), "")(_ + _) == "abc")
  }

  test("append") {
    assert(List.append(List(1, 2, 3), List(4)) == List(1, 2, 3, 4))
  }

  test("appendViaFoldRight") {
    assert(List.appendViaFoldRight(List(1, 2, 3), List(4)) == List(1, 2, 3, 4))
  }

  test("appendViaFoldLeft") {
    assert(List.appendViaFoldLeft(List(1, 2, 3), List(4)) == List(1, 2, 3, 4))
  }

  test("appendAll") {
    val l = List(List(1, 2), List(2, 3, 4), List(4, 5))
    assert(List.appendAll(l) == List(1, 2, 2, 3, 4, 4, 5))
  }

  test("sum3") {
    assert(List.sum(List(1, 3, 5)) == 9)
  }

  test("plusOne") {
    assert(List.plusOne(List(1, 2, 3)) == List(2, 3, 4))
  }

  test("plusOneMap") {
    assert(List.plusOneMap(List(1, 2, 3)) == List(2, 3, 4))
  }

  test("toStrList") {
    assert(List.toStrList(List(1.0, 2.0, 3.0)) == List("1.0", "2.0", "3.0"))
  }

  test("toStrListMap") {
    assert(List.toStrListMap(List(1.0, 2.0, 3.0)) == List("1.0", "2.0", "3.0"))
  }

  test("filter") {
    assert(List.filter(List(1, 2, 3))(i => i % 2 == 0) == List(2))
  }

  test("flatMap") {
    assert(List.flatMap(List(1, 2, 3))(i => List(i, i)) == List(1, 1, 2, 2, 3, 3))
  }

  test("filterViaFlatMap") {
    assert(List.filterViaFlatMap(List(1, 2, 3))(i => i % 2 == 0) == List(2))
  }

  test("addLists") {
    assert(List.addLists(List(1, 2, 3), List(1, 2, 3)) == List(2, 4, 6))
  }

  test("combineTwo") {
    val resultList = List.combineTwo(List(1, 2, 3), List(2, 3, 4))(_ + _)
    assert(resultList == List(3, 5, 7))
  }

  test("hasSubsequence") {
    val l = List(1, 2, 3, 4)
    assert(List.hasSubsequence(l, List(1)) == true)
    assert(List.hasSubsequence(l, List(2, 3)) == true)
    assert(List.hasSubsequence(l, List(4)) == true)
  }
}
