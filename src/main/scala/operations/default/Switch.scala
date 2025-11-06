package operations.default

import operations.Operation
import struct.FlowDirection
import scala.collection.mutable

class Switch extends Operation:
  override def name: String = "switch"
  override def execute(stack: mutable.Stack[Int], prevBlockSize: Int): FlowDirection = 
    if stack.size > 0 then FlowDirection(0, stack.pop()) else FlowDirection.NOCHANGE
