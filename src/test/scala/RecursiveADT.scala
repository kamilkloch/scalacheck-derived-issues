import io.github.martinhh.derived.scalacheck.deriveArbitrary
import org.scalacheck.Arbitrary
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.Checkers

class RecursiveADT extends AnyFunSuite with Checkers {
  given arbitraryTree: Arbitrary[Tree] = deriveArbitrary

  test("test tree") {
    check { (_: Tree) => true }
  }
}
