package operations.default

import operations.Operation
import struct.FlowDirection
import scala.collection.mutable
import scala.io.StdIn
import java.io.EOFException

class InNumber extends Operation:
  override def name: String = "in(number)"
  override def execute(stack: mutable.Stack[Int], prevBlockSize: Int): FlowDirection = 
    try {
      stack.push(StdIn.readInt())
    } catch {
      case _: Exception =>
    }
    FlowDirection.NOCHANGE
