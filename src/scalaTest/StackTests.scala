package scalaTest
import org.scalatest._
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

// Simple stack tests 
class SimpleStackTests extends FlatSpec {

  // Test: a stack should pop values in last-in-first-out order
  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }

  // Test: it should throw IllegalStateException if an empty stack is popped
  it should "throw IllegalStateException if an empty stack is popped" in {
    val emptyStack = new Stack[String]
    intercept[java.lang.IllegalStateException] {
      emptyStack.pop()
    }
  }
}

// More stack tests 
class MoreStackTests extends FlatSpec with StackTraits with BeforeAndAfter {
  
  // Define stack
  def emptyStack = new Stack[Int]
  
  // Define a full stack
  def fullStack = {
    val stack = new Stack[Int]
    for (i <- 0 until stack.MAX)
      stack.push(i)
    stack
  }

  // Define a stack with one item
  def stackWithOneItem = {
    val stack = new Stack[Int]
    stack.push(9)
    stack
  }

  // Define stack with MAX - 1 items 
  def stackWithOneItemLessThanCapacity = {
    val stack = new Stack[Int]
    for (i <- 1 to 9)
      stack.push(i)
    stack
  }

  // Last value pushed 
  val lastValuePushed = 9
  
  // Tests: empty stack tests 
  
  // Test: a Stack (when empty) should be empty
  "A Stack (when empty)" should "be empty" in {
    assert(emptyStack.empty)
  }

  // Test: an empty stack should complain on peek
  it should "complain on peek" in {
    intercept[IllegalStateException] {
      emptyStack.peek
    }
  }

  // Test: an empty stack should complain on pop
  it should "complain on pop" in {
    intercept[IllegalStateException] {
      emptyStack.pop
    }
  }

  // Test: one item stack tests 
  "A Stack (with one item)" should behave like nonEmptyStack(stackWithOneItem, lastValuePushed)

  it should behave like nonFullStack(stackWithOneItem)

  // Tests: one item less than capacity stack tests  
  "A Stack (with one item less than capacity)" should behave like nonEmptyStack(stackWithOneItemLessThanCapacity, lastValuePushed) 
  
  it should behave like nonFullStack(stackWithOneItemLessThanCapacity)

  // Tests: full stack tests 
  "A Stack (full)" should "be full" in {
    assert(fullStack.full)
  }

  it should behave like nonEmptyStack(fullStack, lastValuePushed)

  it should "complain on a push" in {
    intercept[IllegalStateException] {
      fullStack.push(10)
    }
  }
}
  
class StackFunSuiteTests extends FunSuite with BeforeAndAfter {

    // Test: pop on a non-empty stack
    test("pop is invoked on a non-empty stack") {
      val nonEmptyStack = new Stack[Int]
      nonEmptyStack.push(1)
      nonEmptyStack.push(2)
      val oldSize = nonEmptyStack.size
      val result = nonEmptyStack.pop()
      assert(result === 2)
      assert(nonEmptyStack.size === oldSize - 1)
    }
 
    // Test: pop on an empty stack should throw exception
    test("pop is invoked on an empty stack") {
      val emptyStack = new Stack[Int] 
      intercept[java.lang.IllegalStateException] {
        emptyStack.pop()
      }
      assert(emptyStack.empty)
    }
}
