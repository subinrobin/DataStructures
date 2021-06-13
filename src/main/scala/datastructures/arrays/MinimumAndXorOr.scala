package datastructures.arrays

object MinimumAndXorOr extends App {
    val testCases = scala.io.StdIn.readInt()
    for (i <- 1 to testCases) {
        var result = Int.MaxValue
        val arrSize = scala.io.StdIn.readInt()
        val inputArr = scala.io.StdIn.readLine().split(" ").map(_.toInt).sorted // sorting the input
        for (j <- 0 to arrSize - 2) { // finding xor of consecutive elements
            val t = inputArr(j) ^ inputArr(j + 1)
            result = result.min(t)
        }
        println(result)
    }
}