package commands

/**
 * Класс RemoveByIdCommand удаляет автомобиль из коллекции VehicleCollection, предоставляя действительный ID. *
 */
class RemoveById : Command() {
    override fun execute(args: List<Any>): String {
        val id = args[0] as Int
        val removed = VehicleCollection.removeById(id)
        return if (removed) {
            "Vehicle removed successfully."
        } else {
            "No Vehicle found with the provided id."
        }
    }

    override fun readArguments(input: () -> String): List<Any> {
        val idStr = input()
        val id = idStr.toIntOrNull() ?: throw IllegalArgumentException("Invalid ID")
        return listOf(id)
    }
}
