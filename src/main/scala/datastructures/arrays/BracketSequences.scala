package datastructures.arrays

object BracketSequences extends App {
    val inputString = scala.io.StdIn.readLine()
    val suffix = scala.collection.mutable.ArrayBuffer((0, 0))
    var arraySize = 0

    // forming a suffix array which consists of valid sequence for the suffix part of each combination
    inputString.foreach(c => {
        val lastVal = suffix.last
        var openBrace = lastVal._1
        var closeBrace = lastVal._2
        if (c == '(') {
            openBrace += 1
        } else {
            if (openBrace == 0) closeBrace += 1
            else openBrace -= 1
        }
        suffix.append((openBrace, closeBrace))
        arraySize += 1
    })

    var result = 0
    var openBracePre = 0
    var closeBracePre = 0
    // iterating the string in reverse to form the prefix part and validate along with suffix
    for (i <- arraySize - 1 to 0 by -1) {
        val suffixPart = suffix(i)
        if (inputString(i) == '(') {
            if (closeBracePre == 0) openBracePre += 1
            else closeBracePre -= 1
        } else {
            closeBracePre += 1
        }
        // no extra open brace in suffix part, no extra close brace in prefix part
        // extra close brace in sufffix part equals extra open brace in prefix part
        if (suffixPart._1 == 0 && suffixPart._2 == openBracePre && closeBracePre == 0) {
            result += 1
        }
    }
    println(result)
}