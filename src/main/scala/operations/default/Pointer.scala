package operations.default

import operations.Operation
import struct.FlowDirection
import scala.collection.mutable

class Pointer extends Operation:
  override def name: String = "pointer"
  override def execute(stack: mutable.Stack[Int], prevBlockSize: Int): FlowDirection = 
    if stack.size > 0 then FlowDirection(stack.pop(), 0) else FlowDirection.NOCHANGE
