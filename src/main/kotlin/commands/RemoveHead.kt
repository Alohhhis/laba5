package commands

/**
 * Класс RemoveHeadCommand удаляет и возвращает первый элемент в коллекции Vehicle VehicleCollection. *
 */
class RemoveHead : Command() {
    override fun execute(args: List<Any>): String {
        return VehicleCollection.removeHead().toString()
    }

    override fun readArguments(input: () -> String): List<String> {
        return emptyList()
    }
}
