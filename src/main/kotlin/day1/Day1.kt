package org.example.day1

import java.io.File
import kotlin.math.abs

const val FILENAME = "src/main/kotlin/day1/file.txt"

fun getElementFromFile(filename: String): Pair<MutableList<Int>, MutableList<Int>> {
    var leftList: MutableList<Int> = mutableListOf()
    var rightList: MutableList<Int> = mutableListOf()
    File(filename).forEachLine {
        val numberLeft = it.split("   ")[0]
        val numberRight = it.split("   ")[1]
        leftList.add(numberLeft.toInt())
        rightList.add(numberRight.toInt())
    }
    val pair: Pair<MutableList<Int>, MutableList<Int>> = Pair(leftList, rightList)
    return pair

}

object Day1 {
    fun calculateDistance(p: Pair<MutableList<Int>, MutableList<Int>>): Int {
        val leftList = p.first
        val rightList = p.second
        var distances = mutableListOf<Int>()
        leftList.sort()
        rightList.sort()
        var distance: Int
        var i = 0
        while (i < leftList.size) {
            val leftValue = leftList[i]
            val rightValue = rightList[i]
            distance = abs(leftValue - rightValue)
            distances.add(distance)
            i++

        }
        return distances.sum()

    }
}

fun main() {
    val pair = getElementFromFile(FILENAME)
    val distance = Day1.calculateDistance(pair)
    println(distance)


}
