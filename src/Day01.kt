fun main() {
    fun part1(input: List<String>): Int {
        return input.map { value ->
            "${value.first { it.isDigit() }}${value.last { it.isDigit() }}"
        }.map { it.toInt() }
            .sum()
    }

    fun part2(input: List<String>): Int {

        val i = input.map {
            val map = mutableMapOf(
                "1" to Pair(-1, -1),
                "2" to Pair(-1, -1),
                "3" to Pair(-1, -1),
                "4" to Pair(-1, -1),
                "5" to Pair(-1, -1),
                "6" to Pair(-1, -1),
                "7" to Pair(-1, -1),
                "8" to Pair(-1, -1),
                "9" to Pair(-1, -1),
                "one" to Pair(-1, -1),
                "two" to Pair(-1, -1),
                "three" to Pair(-1, -1),
                "four" to Pair(-1, -1),
                "five" to Pair(-1, -1),
                "six" to Pair(-1, -1),
                "seven" to Pair(-1, -1),
                "eight" to Pair(-1, -1),
                "nine" to Pair(-1, -1),
            )

            for (index in map.keys) {
                val min = it.indexOf(index)
                val max = it.lastIndexOf(index)
                map[index] = Pair(min, max)
            }

            val stringToNumber = mapOf(
                "one" to "1",
                "two" to "2",
                "three" to "3",
                "four" to "4",
                "five" to "5",
                "six" to "6",
                "seven" to "7",
                "eight" to "8",
                "nine" to "9",
            )
            val lowest = stringToNumber[map.filter { it.value.first != -1 }.minBy { it.value.first }.key]
                ?: map.filter { it.value.first != -1 }.minBy { it.value.first }.key
            val highest = stringToNumber[map.filter { it.value.second != -1 }.maxBy { it.value.second }.key]
                ?: map.filter { it.value.second != -1 }.maxBy { it.value.second }.key
            "$lowest$highest".toInt()
        }
        return i.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part2(testInput) == readInput("Day01_test_output").first().toInt())


    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

