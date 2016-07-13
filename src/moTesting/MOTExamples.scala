
package moTesting
import org.scalatest.FlatSpec
import org.scalamock.scalatest.MockFactory
/*
 * Function mocks
 * Function mocks are created with mockFunction. 
 * The following, for example, creates a mock function taking a 
 * single Int argument and returning a String:
 * 
 * You can then set expectations set on the mock function. 
 * For example, here's how you'd state that you expect your mock to be called once with the argument 42, 
 * and that when called like that it should return the string "Forty two":
 */
class motExample extends FlatSpec with MockFactory {
  val m = mockFunction[Int, String]
  m expects (42) returning "Forty two" once
}
