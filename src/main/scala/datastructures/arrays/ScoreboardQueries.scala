package datastructures.arrays

object ScoreboardQueries extends App {
    val testCases = scala.io.StdIn.readInt()
    for (i <- 1 to testCases) {
        val line1 = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        val noOfPlayers = line1(0)
        val noOfUpdates = line1(1)
        val score = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        val scoreMap = scala.collection.mutable.Map[Int, Int]()
        var distinctScores = 0

        score.foreach(s => {
            if (scoreMap.contains(s)) {
                scoreMap.put(s, scoreMap(s) + 1)
            } else {
                scoreMap.put(s, 1)
                distinctScores += 1
            }

        })
        for (j <- 1 to noOfUpdates) {
            val line = scala.io.StdIn.readLine().split(" ").map(_.toInt)
            val player = line(0)
            val point = line(1)

            val pastScore = score(player - 1)
            score(player - 1) = point
            scoreMap.put(pastScore, scoreMap(pastScore) - 1)
            if (scoreMap(pastScore) == 0) {
                distinctScores -= 1
            }
            if (scoreMap.getOrElse(point, 0) == 0) {
                scoreMap.put(point, 1)
                distinctScores += 1

            } else {
                scoreMap.put(point, scoreMap(point) + 1)
            }

            println(distinctScores + 1)

        }
    }
}