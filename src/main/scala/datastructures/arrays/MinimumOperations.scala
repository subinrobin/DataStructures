package datastructures.arrays

object MinimumOperations extends App {
    val inputSize = scala.io.StdIn.readInt()
    val inputs = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    var previous = -1
    var steps = 0
    inputs.foreach(n => {
        if (n != previous) {
            steps += 1
        }
        previous = n
    })
    println(steps)
}