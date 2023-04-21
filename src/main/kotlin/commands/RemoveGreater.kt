package commands

import data.Output
import data.Vehicle
import utils.Reader
/**
 * Объект RemoveGreater удаляет из VehicleCollection все транспортные средства с характеристиками.
 * которые превышают заданную.
 *
 */
class RemoveGreater : Command() {
    override fun execute(args: List<Any>): String {
        val Vehicle = args[0] as Vehicle
        val initialSize = VehicleCollection.size()
        VehicleCollection.removeGreater(Vehicle)

        return if (VehicleCollection.size() < initialSize) {
            Output.removedGreater
        } else {
            return Output.nothingToRemove
        }
    }

    override fun readArguments(input: () -> String): List<Any> {
        val Reader = Reader(input, validator)
        val Vehicle = Reader.readVehicle()
        return listOf(Vehicle)
    }
}
