package operations.default

import operations.Operation
import struct.FlowDirection
import scala.collection.mutable

class Mod extends Operation:
  override def name: String = "mod"
  override def execute(stack: mutable.Stack[Int], prevBlockSize: Int): FlowDirection = 
    if stack.size >= 2 && stack.top > 0 then
      val b = stack.pop()
      val a = stack.pop()
      stack.push(if a < 0 then b - ((-a) % b) else a % b)
    FlowDirection.NOCHANGE
