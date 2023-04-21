package commands

/**
 * Класс ShowCommand отображает все транспортные средства в коллекции VehicleCollection. *
 */
class Show : Command() {
    override fun execute(args: List<Any>): String {
        return VehicleCollection.show().joinToString(separator = "\n")
    }
    override fun readArguments(input: () -> String): List<String> {
        return emptyList()
    }
}
