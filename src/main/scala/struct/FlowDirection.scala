package struct

given Conversion[(Int, Int), FlowDirection] with
  def apply(flowDirection: (Int, Int)): FlowDirection =
    FlowDirection(flowDirection._1, flowDirection._2)

case class FlowDirection(
  dp: Int,
  cc: Int
):
  def normalise: FlowDirection =
    val newDP: Int = this.dp % 4
    val newCC: Int = this.cc % 2
    FlowDirection(
      if newDP < 0 then newDP + 4 else newDP, 
      if newCC < 0 then newCC + 2 else newCC
    )

  infix def +(other: FlowDirection): FlowDirection =
    FlowDirection(this.dp + other.dp, this.cc + other.cc).normalise

  infix def - (other: FlowDirection): FlowDirection =
    FlowDirection(this.dp - other.dp, this.cc - other.cc).normalise
end FlowDirection

object FlowDirection:
  val DEFAULT = FlowDirection(0, 0)
  val NOCHANGE = FlowDirection(0, 0)
