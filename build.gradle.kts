tasks {
    task("generateNextDay") {
        doLast {
            val prevDayNum = fileTree("$projectDir/src").matching {
                include("Day*.kt")
            }.maxOf {
                val (prevDayNum) = Regex("Day(\\d\\d)").find(it.name)!!.destructured
                prevDayNum.toInt()
            }
            val newDayNum = String.format("%02d", prevDayNum + 1)
            File("$projectDir/src", "Day$newDayNum.kt").writeText(
                """
fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${newDayNum}_test")
    check(part1(testInput) == readInput("Day${newDayNum}_test_output").first().toInt())

    val input = readInput("Day${newDayNum}")
    part1(input).println()
    part2(input).println()
}

"""

            )

            File("$projectDir/src", "Day$newDayNum.txt").writeText("1")
            File("$projectDir/src", "Day${newDayNum}_test.txt").writeText("1")
            File("$projectDir/src", "Day${newDayNum}_test_output.txt").writeText("1")
        }
    }
}