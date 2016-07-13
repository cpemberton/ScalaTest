package scalaCheck
import org.scalacheck.Prop._
import org.scalacheck.Properties

// Simple property tests using ScalaCheck
object scalaCheck {

  def main(args: Array[String]) = {
    // run the properties
    scalaCheck.runTests
  }
  
  def runTests = {

    // Test: a very simple property: size of the combined list is equal to the sum of the sizes of each list
    val workingProperty = forAll { (l1: List[Int], l2: List[Int]) =>
      l1.size + l2.size == (l1 ::: l2).size
    }

    // Test: this test fails for negative numbers
    val failingProperty = forAll {(n:Double) =>
      Math.sqrt((n*2)) == n
    }

    // Test: this is the correct version of the property test above
    val validSqrtProperty = forAll {(n:Double) =>
      (n > 0) ==> (Math.sqrt((n*2)) == n)
    }

    // Tests: property test combinations
    val combinedProperty1 = workingProperty && failingProperty
    val combinedProperty2 = atLeastOne(workingProperty, failingProperty)

    // run the property tests and grouped specifications
    workingProperty.check
    failingProperty.check
    validSqrtProperty.check
    combinedProperty1.check
    combinedProperty2.check     

  }

}