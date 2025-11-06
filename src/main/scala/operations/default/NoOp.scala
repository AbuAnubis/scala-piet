package operations.default

import operations.Operation
import struct.FlowDirection
import scala.collection.mutable

class NoOp extends Operation:
  override def name: String = "no-op"
  override def execute(stack: mutable.Stack[Int], prevBlockSize: Int): FlowDirection = 
    FlowDirection.NOCHANGE
