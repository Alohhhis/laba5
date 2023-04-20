package commands

import data.Vehicle
import data.Output
import utils.Reader

/**
 * Класс AddIfMaxCommand добавляет новый автомобиль в VehicleCollection, если его значение больше, чем самого большого
 * элемента в VehicleCollection.
 *
 */
class AddIfMax : Command() {

    override fun execute(args: List<Any>): String {
        val Vehicle = args[0] as Vehicle
        val added = VehicleCollection.addIfMax(Vehicle)
        return if (added) Output.Success_added else Output.Not_max
    }

    override fun readArguments(input: () -> String): List<Any> {
        val Reader = Reader(input, validator)
        val Vehicle = Reader.readVehicle()
        return listOf(Vehicle)
    }
}