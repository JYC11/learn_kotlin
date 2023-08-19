package adventOfCode

open class Day02 {
    private val abcToRps = mapOf("A" to "R", "B" to "P", "C" to "S")
    private val xyzToRps = mapOf("X" to "R", "Y" to "P", "Z" to "S")
    private val xyzToWinLoseDraw = mapOf("X" to "lose", "Y" to "draw", "Z" to "win")
    private val rpsToScore = mapOf("R" to 1, "P" to 2, "S" to 3)
    private val resultToScore = mapOf("win" to 6, "lose" to 0, "draw" to 3)

    private fun parseInputIncorrectly(): List<String> {
        var rawInput = readInput("day02")
        abcToRps.forEach { (key, value) ->
            rawInput = rawInput.replace(key, value)
        }
        xyzToRps.forEach { (key, value) ->
            rawInput = rawInput.replace(key, value)
        }
        return rawInput.split("\n")
    }

    private fun parseInput(): List<String> {
        var rawInput = readInput("day02")
        abcToRps.forEach { (key, value) ->
            rawInput = rawInput.replace(key, value)
        }
        xyzToWinLoseDraw.forEach { (key, value) ->
            rawInput = rawInput.replace(key, value)
        }
        return rawInput.split("\n")
    }

    private fun getWinner(you: String, opponent: String): String {
        var result = ""
        when (you) {
            "R" -> result = when (opponent) {
                "S" -> "win"
                "P" -> "lose"
                else -> "draw"
            }

            "P" -> result = when (opponent) {
                "R" -> "win"
                "S" -> "lose"
                else -> "draw"
            }

            "S" -> result = when (opponent) {
                "P" -> "win"
                "R" -> "lose"
                else -> "draw"
            }
        }
        return result
    }

    fun getIncorrectScore(): Int {
        val strategies = parseInputIncorrectly()

        val scores: MutableList<Int> = mutableListOf()
        for (strategy in strategies) {
            val hands: List<String> = strategy.split(" ")
            val opponent: String = hands[0]
            val you: String = hands[1]
            val rpsResult = getWinner(you, opponent)
            val handScore = rpsToScore[you]
            val rpsScore = resultToScore[rpsResult]
            val totalScore = handScore!! + rpsScore!!
            scores.add(totalScore)
        }
        return scores.sum()
    }

    private fun getYourMove(opponent: String, result: String): String {
        var you = ""
        when (opponent) {
            "R" -> when (result) {
                "win" -> you = "P"
                "lose" -> you = "S"
                "draw" -> you = "R"
            }

            "P" -> when (result) {
                "win" -> you = "S"
                "lose" -> you = "R"
                "draw" -> you = "P"
            }

            "S" -> when (result) {
                "win" -> you = "R"
                "lose" -> you = "P"
                "draw" -> you = "S"
            }
        }
        return you
    }

    fun getCorrectScore(): Int {
        val strategies = parseInput()
        val scores: MutableList<Int> = mutableListOf()
        for (strategy in strategies) {
            val split = strategy.split(" ")
            val opponent = split[0]
            val rpsResult = split[1]
            val you = getYourMove(opponent, rpsResult)
            val handScore = rpsToScore[you]
            val rpsScore = resultToScore[rpsResult]
            val totalScore = handScore!! + rpsScore!!
            scores.add(totalScore)
        }
        return scores.sum()
    }
}