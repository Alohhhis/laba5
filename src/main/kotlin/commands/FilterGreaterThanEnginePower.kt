package commands

import exeptions.CommandException

/**
 * Класс FilterGreaterThanEnginePower фильтрует транспортные средства в коллекции VehicleCollection
 * для включения только тех, мощность двигателя которых превышает заданный порог.
 *
 */
class FilterGreaterThanEnginePower : Command() {

    override fun execute(args: List<Any>): String {
        val threshold = (args[0] as String).toIntOrNull() ?: throw CommandException("Invalid threshold: ${args[0]}")
        val filteredList = VehicleCollection.show().filter { it.enginePower > threshold }

        return filteredList.joinToString(separator = "\n")
    }

    override fun readArguments(input: () -> String): List<String> {
        return listOf(input())
    }
}
