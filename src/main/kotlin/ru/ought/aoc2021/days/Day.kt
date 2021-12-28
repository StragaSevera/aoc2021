package ru.ought.aoc2021.days

interface Day {
    companion object {
        fun getInstance(id: String): Day? {
            return try {
                val klass = Class.forName("ru.ought.aoc2021.days.Day$id")
                klass.getDeclaredConstructor().newInstance() as? Day
            } catch (e: ClassNotFoundException) {
                null
            }
        }
    }
    
    fun handle(input: String): String
}