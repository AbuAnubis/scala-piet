package operations.default

import operations.Operation
import struct.FlowDirection
import scala.collection.mutable

class Push extends Operation:
  override def name: String = "push"
  override def execute(stack: mutable.Stack[Int], prevBlockSize: Int): FlowDirection = 
    stack.push(prevBlockSize)
    FlowDirection.NOCHANGE
