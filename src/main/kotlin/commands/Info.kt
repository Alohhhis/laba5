package commands

/**
 * Класс InfoCommand отображает информацию о транспортном средстве VehicleCollection.
 */
class Info : Command() {
    override fun execute(args: List<Any>): String {
        return VehicleCollection.getInfo()
    }

    override fun readArguments(input: () -> String): List<String> {
        return emptyList()
    }
}
