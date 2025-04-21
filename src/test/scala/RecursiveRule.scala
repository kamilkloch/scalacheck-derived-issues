import io.github.martinhh.derived.scalacheck.deriveArbitrary
import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.Checkers
import io.github.martinhh.derived.RecursionFallback

class RecursiveRule extends AnyFunSuite with Checkers {
  implicit override val generatorDrivenConfig: PropertyCheckConfiguration = 
    PropertyCheckConfiguration(minSuccessful = 100, sizeRange = 10)

  given RecursionFallback[Rule] = RecursionFallback(
    Gen.oneOf[Rule](Rule.UseFirst, Rule.UseSecond).map {r => println("*"); r}
  )
  
  given Arbitrary[Rule] = deriveArbitrary

  test("test tree") {
    check { (rule: Rule) =>
      println(rule)
      true
    }
  }
}
