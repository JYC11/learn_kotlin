private fun convertRangesToSet(ranges: List<String>): List<Set<Int>> {
    val firstRange: List<Int> = ranges[0].split("-").map { it.toInt() }
    val secondRange: List<Int> = ranges[1].split("-").map { it.toInt() }
    return listOf(
        (firstRange[0]..firstRange[1]).toSet(),
        (secondRange[0]..secondRange[1]).toSet()
    )
}

fun parseInput(): List<List<Set<Int>>> {
    return readInput("day04")
        .split("\n")
        .map { it.split(",") }
        .map { convertRangesToSet(it) }
}

fun dayFourPartOne(): Int {
    val workAreas = parseInput()
    val counter = workAreas.fold(0) { acc, x ->
        if (x[0] union x[1] == x[0]) acc + 1
        else if (x[0] union x[1] == x[1]) acc + 1
        else acc + 0
    }
    println(counter)
    return counter
}

fun dayFourPartTwo(): Int {
    val workAreas = parseInput()
    val counter = workAreas.fold(0) { acc, x ->
        if ((x[0] intersect x[1]).isNotEmpty()) acc + 1
        else acc + 0
    }
    println(counter)
    return counter
}