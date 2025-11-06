package operations.default

import operations.Operation
import struct.FlowDirection
import scala.collection.mutable

class OutChar extends Operation:
  override def name: String = "out(char)"
  override def execute(stack: mutable.Stack[Int], prevBlockSize: Int): FlowDirection = 
    if stack.size > 0 then
      val top = stack.pop()
      print(top.toChar)
    FlowDirection.NOCHANGE
