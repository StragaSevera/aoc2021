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
        val resourceName = Regex("Day(.*)").find(className)?.groupValues?.get(1)
            ?: error("There class $className cannot have a resource!")
        val resourceFileName = "${resourceName}.txt"
        val resourceContents = javaClass.getResourceAsStream(resourceFileName)?.reader()?.use { it.readText() }
            ?: error("The resource $resourceFileName cannot be read!")
        return handle(resourceContents)

    }

    fun handle(input: String): String
}