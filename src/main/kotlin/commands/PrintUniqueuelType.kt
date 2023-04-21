package commands

/**
 * Класс PrintUniqueFuelType возвращает строковое представление уникальных типов топлива
 * присутствующих в транспортных средствах в коллекции VehicleCollection.
 *
 */
class PrintUniqueFuelType : Command() {

    override fun execute(args: List<Any>): String {
        val uniqueFuelTypes = VehicleCollection.show().map { it.fuelType }.distinct()
        val formattedOutput = uniqueFuelTypes.joinToString("\n")
        return formattedOutput
    }

    override fun readArguments(input: () -> String): List<Any> {
        return emptyList()
    }
}