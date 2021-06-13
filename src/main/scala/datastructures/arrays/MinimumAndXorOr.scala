package datastructures.arrays



object MaximizeTheSum extends App {
    val testCases = scala.io.StdIn.readInt()
    for (i <- 1 to testCases) {
        val args2 = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        val arrSize = args2(0)
        val noOfElems = args2(1)
        val elems = scala.io.StdIn.readLine().split(" ").map(_.toLong)
        val tracker = scala.collection.mutable.Map[Long, Long]()
        
        elems.foreach(c => {
            if(c > 0) {
                tracker.put(c, tracker.getOrElse(c, 0L) + c)
            }
        })
        val elemSum = tracker.values.toArray.sorted
        println(elemSum.takeRight(noOfElems).sum)
    }
}