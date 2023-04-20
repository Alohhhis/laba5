package commands

import data.Output

/**
 * Класс ClearCommand очищает коллекцию Vehicle VehicleCollection. *
 */
class Clear : Command() {
    override fun execute(args: List<Any>): String {
        VehicleCollection.clear()
        return Output.Success_clear
    }

    override fun readArguments(input: () -> String): List<String> {
        return emptyList()
    }
}
