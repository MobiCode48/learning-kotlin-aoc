package org.example.day3

import java.io.File


const val FILENAME = "src/main/kotlin/day3/file.txt"

fun getElementfromFile(filename: String): List<Pair<Int, Int>> {
    val pattern = Regex("""mul\((\d+),(\d+)\)""")
    val data = File(filename).readLines().toString()
    val multiples = mutableListOf<Pair<Int, Int>>()
    val matches = pattern.findAll(data).forEach { it ->
        val first = it.groupValues[1].toInt()
        val second = it.groupValues[2].toInt()
        val pair = first to second
        multiples.add(pair)
    }
    return multiples
}

object Day3 {
    var sum = 0
    fun mullItOver(multiples: List<Pair<Int, Int>>): Int {
        for (groupMultiple in multiples) {
            sum += groupMultiple.first * groupMultiple.second
        }
        return sum
    }


}

fun main() {
    println(Day3.mullItOver(getElementfromFile(FILENAME)))
}