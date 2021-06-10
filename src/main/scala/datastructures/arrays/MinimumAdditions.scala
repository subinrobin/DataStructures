package datastructures.arrays

object MinimumAdditions extends App {

    val noOfTests = scala.io.StdIn.readLine().toInt
    for (i <- 1 to noOfTests) {
        val inp = scala.io.StdIn.readLine().split(" ")
        val arrayLen = inp(0).toLong
        val limit = inp(1).toLong
        val arraySum = scala.io.StdIn.readLine().split(" ").map(_.toLong).sum
        val r = (arraySum / (limit + 1)) - arrayLen + 1
        println(r.max(0))
    }
}