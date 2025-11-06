//> using lib "org.scalameta::munit::0.7.29"
import scala.collection.mutable.Stack
import operations
import struct.FlowDirection

class TestDefaultOperations extends munit.FunSuite:
  test("Push operation") {
    val stack: Stack[Int] = Stack[Int](4, 8, 5)
    val operation: operations.Operation = new operations.default.Push
    val n: Int = 9

    operation.execute(stack, n)

    assertEquals(stack.size, 4)
    assertEquals(stack.top, n)
  }

  test("Pop operation") {
    val stack: Stack[Int] = Stack[Int](4, 8, 5)
    val emptyStack: Stack[Int] = Stack[Int]()
    val operation: operations.Operation = new operations.default.Pop

    operation.execute(stack, 0)
    operation.execute(emptyStack, 0)

    assertEquals(stack.size, 2)
    assertEquals(stack.top, 8)
    assertEquals(emptyStack.size, 0)
  }

  test("Add operation") {
    val stack: Stack[Int] = Stack[Int](4, 8, 5)
    val smallStack: Stack[Int] = Stack[Int](4)
    val emptyStack: Stack[Int] = Stack[Int]()
    val operation: operations.Operation = new operations.default.Add

    operation.execute(stack, 0)
    operation.execute(smallStack, 0)
    operation.execute(emptyStack, 0)

    assertEquals(stack.size, 2)
    assertEquals(stack.top, 13)
    assertEquals(smallStack.size, 1)
    assertEquals(smallStack.top, 4)
    assertEquals(emptyStack.size, 0)
  }

  test("Subtract operation") {
    val stack: Stack[Int] = Stack[Int](4, 8, 5)
    val smallStack: Stack[Int] = Stack[Int](4)
    val emptyStack: Stack[Int] = Stack[Int]()
    val operation: operations.Operation = new operations.default.Subtract

    operation.execute(stack, 0)
    operation.execute(smallStack, 0)
    operation.execute(emptyStack, 0)

    assertEquals(stack.size, 2)
    assertEquals(stack.top, 3)
    assertEquals(smallStack.size, 1)
    assertEquals(smallStack.top, 4)
    assertEquals(emptyStack.size, 0)
  }

  test("Multiply operation") {
    val stack: Stack[Int] = Stack[Int](4, 8, 5)
    val smallStack: Stack[Int] = Stack[Int](4)
    val emptyStack: Stack[Int] = Stack[Int]()
    val operation: operations.Operation = new operations.default.Multiply

    operation.execute(stack, 0)
    operation.execute(smallStack, 0)
    operation.execute(emptyStack, 0)

    assertEquals(stack.size, 2)
    assertEquals(stack.top, 40)
    assertEquals(smallStack.size, 1)
    assertEquals(smallStack.top, 4)
    assertEquals(emptyStack.size, 0)
  }

  test("Divide operation") {
    val stack: Stack[Int] = Stack[Int](4, 17, 5)
    val zeroEndingStack: Stack[Int] = Stack[Int](4, 8, 0)
    val smallStack: Stack[Int] = Stack[Int](4)
    val emptyStack: Stack[Int] = Stack[Int]()
    val operation: operations.Operation = new operations.default.Divide

    operation.execute(stack, 0)
    operation.execute(zeroEndingStack, 0)
    operation.execute(smallStack, 0)
    operation.execute(emptyStack, 0)

    assertEquals(stack.size, 2)
    assertEquals(stack.top, 3)
    assertEquals(zeroEndingStack.size, 3)
    assertEquals(zeroEndingStack.top, 0)
    assertEquals(smallStack.size, 1)
    assertEquals(smallStack.top, 4)
    assertEquals(emptyStack.size, 0)
  }

  test("Mod operation") {
    val stack: Stack[Int] = Stack[Int](4, 17, 5)
    val zeroEndingStack: Stack[Int] = Stack[Int](4, 8, 0)
    val smallStack: Stack[Int] = Stack[Int](4)
    val emptyStack: Stack[Int] = Stack[Int]()
    val operation: operations.Operation = new operations.default.Mod

    operation.execute(stack, 0)
    operation.execute(zeroEndingStack, 0)
    operation.execute(smallStack, 0)
    operation.execute(emptyStack, 0)

    assertEquals(stack.size, 2)
    assertEquals(stack.top, 2)
    assertEquals(zeroEndingStack.size, 3)
    assertEquals(zeroEndingStack.top, 0)
    assertEquals(smallStack.size, 1)
    assertEquals(smallStack.top, 4)
    assertEquals(emptyStack.size, 0)
  }

  test("Not operation") {
    val stack: Stack[Int] = Stack[Int](4, 17, 5)
    val zeroEndingStack: Stack[Int] = Stack[Int](4, 8, 0)
    val emptyStack: Stack[Int] = Stack[Int]()
    val operation: operations.Operation = new operations.default.Not

    operation.execute(stack, 0)
    operation.execute(zeroEndingStack, 0)
    operation.execute(emptyStack, 0)

    assertEquals(stack.size, 3)
    assertEquals(stack.top, 0)
    assertEquals(zeroEndingStack.size, 3)
    assertEquals(zeroEndingStack.top, 1)
    assertEquals(emptyStack.size, 0)
  }

  test("Greater operation") {
    val greaterStack: Stack[Int] = Stack[Int](4, 17, 5)
    val lesserStack: Stack[Int] = Stack[Int](4, 5, 17)
    val equalStack: Stack[Int] = Stack[Int](4, 17, 17)
    val singleStack: Stack[Int] = Stack[Int](4)
    val emptyStack: Stack[Int] = Stack[Int]()
    val operation: operations.Operation = new operations.default.Greater

    operation.execute(greaterStack, 0)
    operation.execute(lesserStack, 0)
    operation.execute(equalStack, 0)
    operation.execute(singleStack, 0)
    operation.execute(emptyStack, 0)

    assertEquals(greaterStack.size, 2)
    assertEquals(greaterStack.top, 1)
    assertEquals(lesserStack.size, 2)
    assertEquals(lesserStack.top, 0)
    assertEquals(equalStack.size, 2)
    assertEquals(equalStack.top, 0)
    assertEquals(singleStack.size, 1)
    assertEquals(singleStack.top, 4)
    assertEquals(emptyStack.size, 0)
  }

  test("Pointer operation") {
    val stack: Stack[Int] = Stack[Int](4, 8, 5)
    val emptyStack: Stack[Int] = Stack[Int]()
    val operation: operations.Operation = new operations.default.Pointer

    val res1 = operation.execute(stack, 0)
    val res2 = operation.execute(emptyStack, 0)

    assertEquals(stack.size, 2)
    assertEquals(stack.top, 8)
    assertEquals(res1.dp % 4, 1)
    assertEquals(res1.cc, 0)
    assertEquals(emptyStack.size, 0)
    assertEquals(res2, FlowDirection.NOCHANGE)
  }

  test("Switch operation") {
    val stack: Stack[Int] = Stack[Int](4, 8, 5)
    val emptyStack: Stack[Int] = Stack[Int]()
    val operation: operations.Operation = new operations.default.Switch

    val res1 = operation.execute(stack, 0)
    val res2 = operation.execute(emptyStack, 0)

    assertEquals(stack.size, 2)
    assertEquals(stack.top, 8)
    assertEquals(res1.dp, 0)
    assertEquals(res1.cc, 0)
    assertEquals(emptyStack.size, 0)
    assertEquals(res2, FlowDirection.NOCHANGE)
  }

  test("Duplicate operation") {
    val stack: Stack[Int] = Stack[Int](4, 8, 5)
    val emptyStack: Stack[Int] = Stack[Int]()
    val operation: operations.Operation = new operations.default.Duplicate

    operation.execute(stack, 0)
    operation.execute(emptyStack, 0)

    assertEquals(stack.size, 4)
    assertEquals(stack.pop(), 5)
    assertEquals(stack.top, 5)
    assertEquals(emptyStack.size, 0)
  }

  test(" operation") {
    val stack: Stack[Int] = Stack[Int](4, 8, 5)
    val emptyStack: Stack[Int] = Stack[Int]()
    val operation: operations.Operation = new operations.default.

    operation.execute(stack, 0)
    operation.execute(emptyStack, 0)

    assertEquals(stack.size, )
    assertEquals(stack.top, )
    assertEquals(emptyStack.size, )
  }
