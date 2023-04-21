package commands

import exeptions.ValidationException
import utils.Reader

/**
 * Класс UpdateCommand отвечает за обновление конкретного автомобиля в коллекции VehicleCollection
 * путем предоставления действительного ID.
 *
 */
class Update : Command() {

    override fun execute(args: List<Any>): String {
        if (args.isEmpty() || args[0] !is String) {
            return "ID is not provided or has an incorrect format."
        }

        val id: Int = try {
            args[0].toString().toInt()
        } catch (e: NumberFormatException) {
            return "Invalid ID format. Please enter a valid number."
        }

        val VehicleToUpdate = VehicleCollection.show().find { it.id == id }

        return if (VehicleToUpdate != null) {
            try {
                val Reader = Reader({ readlnOrNull() ?: "" }, validator)
                val updatedVehicle = Reader.readVehicle(id, VehicleToUpdate.creationDate)
                VehicleCollection.update(id, updatedVehicle)
                "Vehicle with ID: $id has been updated."
            } catch (e: ValidationException) {
                "Failed to update Vehicle due to invalid input: ${e.message}"
            }
        } else {
            "No Vehicle found with ID: $id."
        }
    }

    override fun readArguments(input: () -> String): List<Any> {
        val inputString = input()
        return listOf(inputString.trim())
    }
}
