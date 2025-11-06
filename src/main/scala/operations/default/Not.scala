package operations.default

import operations.Operation
import struct.FlowDirection
import scala.collection.mutable

class Not extends Operation:
  override def name: String = "not"
  override def execute(stack: mutable.Stack[Int], prevBlockSize: Int): FlowDirection = 
    if stack.size > 0 then
      val top = stack.pop()
      stack.push(if top == 0 then 1 else 0)
    FlowDirection.NOCHANGE
