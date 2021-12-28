package ru.ought.aoc2021

import ru.ought.aoc2021.days.Day

fun main() {
    val dayName = "01a"
    val day = Day.getInstance(dayName)
    if (day == null) {
        println("There is no day like this day: $dayName")
        return
    }
    println(day.handle("test"))
}