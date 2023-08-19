package adventOfCode

class Day03 {
    private fun toScore(x: Char): Int {
        var score = 0
        score += if (x.isLowerCase()) {
            x.code - 96
        } else {
            x.code - 38
        }
        return score
    }

    private fun getCommonChar(x: String): Char {
        val mid: Int = x.length / 2
        val first: Set<Char> = x.substring(0, mid).toSet()
        val second: Set<Char> = x.substring(mid).toSet()
        val common: Set<Char> = first intersect second
        return common.first()
    }

    private fun parseInput(): List<String> {
        return readInput("day03").split("\n")
    }

    fun getScorePartOne(): Int {
        val commonChars: List<Char> = parseInput().map { getCommonChar(it) }
        val scores: List<Int> = commonChars.map { toScore(it) }
        return scores.sum()
    }

    fun getScorePartTwo(): Int {
        val inputs: List<Set<Char>> = parseInput().map { it.toSet() }
        val scores: MutableList<Int> = mutableListOf<Int>()
        val temp: MutableList<Set<Char>> = mutableListOf()
        for (input in inputs) {
            if (temp.size < 3) {
                temp.add(input)
            }
            if (temp.size == 3) {
                val common: Set<Char> = temp[0] intersect temp[1] intersect temp[2]
                scores.add(toScore(common.first()))
                temp.clear()
            }
        }
        return scores.sum()
    }
}