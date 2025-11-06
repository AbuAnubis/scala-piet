import config.DefaultConfig
import struct.Compass
import scala.collection.mutable.Stack
import operations.default.InChar

object Appl:
  @main def testThat(): Unit =
    // println(9)
    // val reader = ImageReader("src/main/resources/artistic-hello-world.gif")
    // val compiler = CodelCompiler(reader, new DefaultConfig)
    // val blocks = compiler.generateAllBlocks()
    // println(blocks.mkString("\n"))
    // val printableMap = compiler.blockMap.map(x =>
    //   if 0 <= x && x < 10 then s"0$x" else x.toString
    // )
    // val printableMap = compiler.blockMap.map(x => if x == 1 then "X" else "-")

    // println(printableMap)

    // val mergeFar = Compass.mergeWithComparator[Int, Int]((x: Int, y: Int) => x - y)
    // println(mergeFar(Compass[Int](0, 1, 2, 3), Compass[Int](4, 5, 6, 7)))

    val stack: Stack[Int] = Stack() 
    val inchar = new InChar
    for i <- 1 to 10 do
      inchar.execute(stack, 0)
      println(stack.top)
      
