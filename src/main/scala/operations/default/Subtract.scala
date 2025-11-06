package operations.default

import operations.Operation
import struct.FlowDirection
import scala.collection.mutable

class Subtract extends Operation:
  override def name: String = "subtract"
  override def execute(stack: mutable.Stack[Int], prevBlockSize: Int): FlowDirection = 
    if stack.size >= 2 then
      val b = stack.pop()
      val a = stack.pop()
      stack.push(a - b)
    FlowDirection.NOCHANGE
