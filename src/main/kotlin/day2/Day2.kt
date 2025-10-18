package org.example.day2

import java.io.File
import kotlin.math.abs

const val FILENAME = "src/main/kotlin/day2/file.txt"

fun getDataFromFile(filename : String) : List<List<Int>> {
    return File(filename).readLines().map { line -> line.split(" ").map { it.toInt() } }
}



object Day2 {

    fun allIncreasing(levels : List<Int>) : Boolean {
        var idx = 0
        var isIncreasing = true
       while (idx < levels.size - 1 && isIncreasing) {
           val current = levels[idx]
           val next = levels[idx+1]
           if (next < current) {
               isIncreasing = false
           }
           idx++
       }
        return isIncreasing
    }

    fun allDecreasing(levels : List<Int>) : Boolean {
        var idx = 0
        var isDecreasing = true
        while (idx < levels.size - 1 && isDecreasing) {
            val current = levels[idx]
            val next = levels[idx+1]
            if (current < next) {
                isDecreasing = false
            }
            idx++
        }
        return isDecreasing
    }

    fun isSafe(levels : List<Int>) : Boolean {
        if (!allIncreasing(levels) && !allDecreasing(levels)) {
            return false
        }
        for (idx in 0 until levels.size-1) {
            val diff = abs(levels[idx] - levels[idx + 1])
            if (diff < 1 || diff > 3) {
                return false
                }
            }
        return true
    }


    fun getSafeRecords(levels : List<List<Int>>) : Int {
        var count = 0
        for (level in levels) {
            if (isSafe(level)) {
                count++
            }
        }
        return count
    }

}

fun main() {
    val data = getDataFromFile(FILENAME)
    println(Day2.getSafeRecords(data))
}