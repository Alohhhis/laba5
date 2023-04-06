package data

import java.time.LocalDateTime


data class Vehicle(
    val id: Int,//Значение поля должно быть больше 0,
    // Значение этого поля должно быть уникальным,
    // Значение этого поля должно генерироваться автоматически
    val name: String, //Поле не может быть null, Строка не может быть пустой
    val coordinates: Coordinates,//Поле не может быть null
    val creationDate: LocalDateTime,//Поле не может быть null,
    // Значение этого поля должно генерироваться автоматически
    val enginePower: Int,//Значение поля должно быть больше 0
    val distanceTravelled: Double,//Значение поля должно быть больше 0
    val type: VehicleType,//Поле может быть null
    val fuelType: FuelType,//Поле может быть null
)