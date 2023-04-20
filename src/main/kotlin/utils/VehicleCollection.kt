package utils

import data.*
import java.time.LocalDate
import java.util.PriorityQueue
import kotlinx.serialization.builtins.ListSerializer

/**
 * Класс, отвечающий за управление коллекцией транспортных средств VehicleCollection. *
 */
class VehicleCollection(val fileName: String) {
     val VehicleQueue = PriorityQueue<Vehicle>()

    init {
        loadFromFile()
    }


    private fun loadFromFile() {
        try {
            val VehicleList = JsonUtil.loadFromFile(fileName, ListSerializer(Vehicle.serializer()))
            VehicleList?.let { VehicleQueue.addAll(it) }
        } catch (e: kotlinx.serialization.SerializationException) {
            println("Error: Failed to load data from file. The file might be empty or contain invalid content. Starting with an empty VehicleCollection.")
        }
    }


    fun saveToFile() {
        JsonUtil.saveToFile(VehicleQueue.toList(), fileName, ListSerializer(Vehicle.serializer()))
    }

    companion object {

        fun fromFile(fileName: String): VehicleCollection {
            return VehicleCollection(fileName)
        }
    }


    fun add(Vehicle: Vehicle) {
        VehicleQueue.add(Vehicle)
    }


    fun removeById(id: Int): Boolean {
        val initialSize = VehicleQueue.size
        VehicleQueue.removeIf { it.id == id }
        return VehicleQueue.size < initialSize
    }


    fun clear() {
        VehicleQueue.clear()
    }

    fun show(): List<Vehicle> {
        return VehicleQueue.toList()
    }

     fun size(): Int {
        return VehicleQueue.size
    }


    private fun getCreationDate(): LocalDate {
        return LocalDate.now()
    }

    fun addIfMax(Vehicle: Vehicle): Boolean {
        val maxVehicle = VehicleQueue.maxWithOrNull(compareBy { it.id })
        if (maxVehicle == null || compareBy<Vehicle> { it.id }.compare(maxVehicle, Vehicle) < 0) {
            VehicleQueue.add(Vehicle)
            return true
        }
        return false
    }

    fun removeHead(): Vehicle? {
        return VehicleQueue.poll()
    }


    fun getInfo(): String {
        return "VehicleCollection type: ${VehicleQueue::class.simpleName}\n" +
                "Initialization date: ${getCreationDate()}\n" +
                "Number of elements: ${size()}"
    }


    fun update(id: Int, newVehicle: Vehicle): Boolean {
        val Vehicle = VehicleQueue.find { it.id == id }
        return if (Vehicle != null) {
            val updatedVehicle = Vehicle(
                id = Vehicle.id,
                name = newVehicle.name,
                coordinates = newVehicle.coordinates,
                creationDate = Vehicle.creationDate,
                enginePower = newVehicle.enginePower,
                distanceTravelled = newVehicle.distanceTravelled,
                type = newVehicle.type,
                fuelType = newVehicle.fuelType
            )

            VehicleQueue.remove(Vehicle)
            VehicleQueue.add(updatedVehicle)

            true
        } else {
            false
        }
    }
    fun removeGreater(vehicle: Vehicle): Int {
        val iterator = VehicleQueue.iterator()
        var count = 0
        while (iterator.hasNext()) {
            val currentVehicle = iterator.next()
            if (currentVehicle >= vehicle) {
                iterator.remove()
                count++
            }
        }
        return count
    }



}
