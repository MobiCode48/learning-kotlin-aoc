package org.example.day1

import java.io.File

fun getElementFromFile(filename : String) : String {
    val reader = File(filename).bufferedReader()
    val text = reader.use { it.readText() }
    return text
}

object day1 {

}

fun main() {
    println(getElementFromFile("file.txt"))
}