package operations.default

import operations.Operation
import struct.FlowDirection
import scala.collection.mutable

class Pop extends Operation:
  override def name: String = "pop"
  override def execute(stack: mutable.Stack[Int], prevBlockSize: Int): FlowDirection = 
    if stack.size > 0 then stack.pop()
    FlowDirection.NOCHANGE
