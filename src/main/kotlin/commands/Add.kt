package commands

import data.*
import utils.Reader
/**
 * Команда Add добавляет ноыое транспортное средство в коллекцию
 *
 */
class Add : Command() {


    override fun execute(args: List<Any>): String {
        val Vehicle = args[0] as Vehicle
        VehicleCollection.add(Vehicle)
        return Output.Success_added
    }

    override fun readArguments(input: () -> String): List<Any> {
        val Reader = Reader(input, validator)
        val Vehicle = Reader.readVehicle()
        return listOf(Vehicle)
    }
}
