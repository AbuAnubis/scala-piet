package operations.default

import operations.Operation
import struct.FlowDirection
import scala.collection.mutable

class Greater extends Operation:
  override def name: String = "greater"
  override def execute(stack: mutable.Stack[Int], prevBlockSize: Int): FlowDirection = 
    if stack.size >= 2 then
      val b = stack.pop()
      val a = stack.pop()
      stack.push(if a > b then 1 else 0)
    FlowDirection.NOCHANGE
