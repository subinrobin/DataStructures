package datastructures.arrays

object MaximizeTheModuloFunction extends App {
    val testCases = scala.io.StdIn.readInt()
    for (i <- 1 to testCases) {
        val inp = scala.io.StdIn.readLine().split(" ")
        val (size, mod) = (inp(0).toInt, inp(1).toLong)
        val num = scala.io.StdIn.readLine()
        val prefix = scala.collection.mutable.ArrayBuffer(0L)
        num.foreach(c => {
            val r = (c.asDigit + (prefix.last * 10)) % mod
            prefix.append(r)
        })
        var ans = prefix.last % mod
        var currPow = 1L
        var suffix = 0L
        for (i <- size - 1 to 0 by -1) {
            ans = ans.max(((prefix(i) * currPow % mod) + suffix) % mod)
            suffix = suffix + (num(i).asDigit * currPow)
            suffix = suffix % mod
            currPow = currPow * 10 % mod
        }
        println(ans)

    }
}