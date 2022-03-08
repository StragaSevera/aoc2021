package ru.ought.aoc2021

import ru.ought.aoc2021.days.Day

fun main(args: Array<String>) {
    try {
        val dayName = args.getOrNull(0) ?: error("No day name given!")
        val day = Day.getInstance(dayName)
        if (day == null) {
            println("Day doesn't exist: $dayName")
            return
        }
        println(day.handleResource())
    } catch (e: Exception) {
      println("Application error: ${e.message}")
    }
}