package data

import kotlinx.serialization.Serializable

/**
 *Дата класс содержащий значения координат 'x' и 'y'
 */

@Serializable
data class Coordinates(
    val x: Long,//Поле не может быть null
    val y: Double//Максимальное значение поля: 297, Поле не может быть null
)