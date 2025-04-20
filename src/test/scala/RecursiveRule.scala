import io.github.martinhh.derived.scalacheck.deriveArbitrary
import org.scalacheck.Arbitrary
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.Checkers

class RecursiveRule extends AnyFunSuite with Checkers {
  implicit override val generatorDrivenConfig: PropertyCheckConfiguration = PropertyCheckConfiguration(minSuccessful = 100)

  given arbitraryTree: Arbitrary[Rule] = deriveArbitrary

  test("test tree") {
    check { (rule: Rule) =>
      println(rule)
      true
    }
  }
}
