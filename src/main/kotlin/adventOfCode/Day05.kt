package adventOfCode

class Day05 {
    fun printInput() {
        val input = readInput("day05").split("\n\n")
        val crateRows: List<String> = input[0]
            .replace("    ", " [&]")
            .split("\n")
            .filter { !it.contains("1") }
            .map { it.trim() }
            .map { it.replace("][", "] [") }

        val crates = mutableMapOf<Int, MutableList<String>>(
            1 to mutableListOf<String>(),
            2 to mutableListOf<String>(),
            3 to mutableListOf<String>(),
            4 to mutableListOf<String>(),
            5 to mutableListOf<String>(),
            6 to mutableListOf<String>(),
            7 to mutableListOf<String>(),
            8 to mutableListOf<String>(),
            9 to mutableListOf<String>(),
        )

        for (crateRow in crateRows) {
            var i = 0
            val temp = crateRow.split(" ")
            while (i < 9 && i < temp.size) {
                val crate = temp[i]
                    .replace("[", "")
                    .replace("]", "")
                if (crate != "&") {
                    crates[i + 1]?.add(crate)
                }
                i += 1
            }
        }

        crates.forEach { (key, value) ->
            println("col: $key, crates: $value")
        }
    }
}