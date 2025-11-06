package operations.default

import operations.Operation
import struct.FlowDirection
import scala.collection.mutable

class Duplicate extends Operation:
  override def name: String = "duplicate"
  override def execute(stack: mutable.Stack[Int], prevBlockSize: Int): FlowDirection = 
    if stack.size > 0 then
      stack.push(stack.top)
    FlowDirection.NOCHANGE
