fun main() {

    data class Set(val green: Int = 0, val red: Int = 0, val blue: Int = 0)

    data class Game(val id: Int, val sets: List<Set>)

    fun games(input: List<String>) = input.map {
        val gameAndSets = it.split(":")
        val game = gameAndSets[0].removePrefix("Game ").toInt()
        val sets = gameAndSets[1].trim().split(";").map { set ->
            val items = set.trim().split(",")
                .map { color ->
                    val c = color.trim().split(" ")
                    Pair(c[1], c[0].toInt())
                }.toMap()

            Set(items["green"] ?: 0, items["red"] ?: 0, items["blue"] ?: 0)
        }

        Game(game, sets)
    }

    fun part1(input: List<String>): Int {
        val red = 12
        val green = 13
        val blue = 14
        val i = games(input).filter {
            it.sets.count { set ->
                set.green > green || set.red > red || set.blue > blue
            } == 0
        }.sumOf { it.id }
        return i
    }

    fun part2(input: List<String>): Int {
        return games(input).sumOf {
            val maxGreen = it.sets.maxOf { set -> set.green }
            val maxRed = it.sets.maxOf { set -> set.red }
            val maxBlue = it.sets.maxOf { set -> set.blue }

            maxGreen * maxRed * maxBlue
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput1 = readInput("Day02_test_1")
    val testInput2 = readInput("Day02_test_2")

    check(part1(testInput1) == readInput("Day02_test_output_1").first().toInt())
    check(part2(testInput2) == readInput("Day02_test_output_2").first().toInt())


    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()


}

