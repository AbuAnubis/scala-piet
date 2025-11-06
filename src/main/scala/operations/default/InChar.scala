package operations.default

import operations.Operation
import struct.FlowDirection
import scala.collection.mutable
import scala.io.StdIn
import java.io.EOFException

class InChar extends Operation:
  private var previousLine: String = ""
  override def name: String = "in(char)"
  override def execute(stack: mutable.Stack[Int], prevBlockSize: Int): FlowDirection = 
    if previousLine.isEmpty() then previousLine = StdIn.readLine().match {
      case null => ""
      case s: String => s
    }
    if !previousLine.isEmpty() then
      stack.push(previousLine.codePointAt(0))
      previousLine = previousLine.tail
    FlowDirection.NOCHANGE
