package operations

import scala.collection.mutable.Stack
import struct.FlowDirection

trait Operation:
  def name: String

  /**
    * Executes this operation
    *
    * @param stack current program stack
    * @param prevBlockSize number of codels in just exited codel block
    * @return FlowDirection representing **change** of the program's DP and CC.
    *         If no change is made, [[FlowDirection.NOCHANGE]] should be returned
    */
  def execute(stack: Stack[Int], prevBlockSize: Int): FlowDirection
