package commands

import data.Output

/**
 * Класс SaveCommand сохраняет коллекцию Vehicle VehicleCollection в файл. *
 */
class Save : Command() {
    override fun execute(args: List<Any>): String {
        VehicleCollection.saveToFile()
        return Output.Success_save
    }

    override fun readArguments(input: () -> String): List<String> {
        return emptyList()
    }
}
