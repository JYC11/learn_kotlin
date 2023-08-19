package adventOfCode

open class Day01 {
    private fun parseInput(): List<Int> {
        val toIntIfNumber = { x: String ->
            if (x.isNotEmpty()) {
                x.toInt()
            } else {
                0
            }
        }
        return readInput("day01").split("\n").map { toIntIfNumber(it) }
    }

    private fun getCalorieSums(): MutableList<Int> {
        val calories: List<Int> = parseInput()
        val calorieSums: MutableList<Int> = mutableListOf<Int>()
        var temp = 0
        for (calorie in calories) {
            if (calorie > 0) {
                temp += calorie
            } else if (calorie == 0) {
                calorieSums.add(temp)
                temp = 0
            }
        }
        return calorieSums
    }

    fun getMaxCalorie(): Int {
        val calorieSums = getCalorieSums()
        return calorieSums.max()
    }

    fun getTopThree(): List<Int> {
        val calorieSums = getCalorieSums()
        calorieSums.sortDescending()
        return calorieSums.subList(0, 3)
    }
}