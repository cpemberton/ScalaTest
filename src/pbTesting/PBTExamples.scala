package pbTesting
/**
 * Examples of writing mixed unit/property-based (ScalaCheck) tests.
 *
 * Includes tables and generators as well as 'traditional' tests.
 *
 * @see http://www.scalatest.org/user_guide/selecting_a_style
 * @see http://www.scalatest.org/user_guide/property_based_testing
 */
import org.scalatest._
import prop._
import scala.collection.immutable._ // For BitSet
import java.awt.Color

/**
 * This is what ScalaTest calls the ScalaCheck style of property-driven test.
 * See http://www.scalatest.org/user_guide/writing_scalacheck_style_properties#selectingAStyle
 *
 */
class pbtExample extends PropSpec with Matchers with Checkers with PropertyChecks {

  /* 
   * Test: a very simple property that the size of the combined list is equal to:
   * the sum of the sizes of each constituent list
   */
  property("Combined List Size Equal to Sum of Sizes of Constituent Lists") {
    check((a: List[Int], b: List[Int]) => a.size + b.size == (a ::: b).size) 
  }

  property("This test should fail for negative numbers") {
    // Test: this test fails for negative numbers
    check ((n:Int) => Math.sqrt((n*2)) == n)
  }
  
  import org.scalacheck.Prop._ // needed for ==>
  
  
  property("This is the correct version of the property test above") {
    // Test: this is the correct version of the property test above
    // Using ==> rather than "whenever" which is used in the ScalaTest style
    forAll { (n: Double) => whenever(n > 0) {  Math.sqrt((n*2)) == n }
    }
  }
}
