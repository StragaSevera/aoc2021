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

    fun handleResource(): String {
        val className = javaClass.simpleName
        val resource = Regex("Day(.*)").find(className)?.groupValues?.get(1)
            ?: error("There is no resource for the class $className")
        val resourceName = "${resource}.txt"
        val resourceContents = javaClass.getResourceAsStream(resourceName)?.reader()?.use { it.readText() }
            ?: error("The resource $resourceName cannot be read!")
        return handle(resourceContents)

    }

    fun handle(input: String): String
}