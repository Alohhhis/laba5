package data

import kotlinx.serialization.Serializable

@Serializable
enum class FuelType {
    ELECTRICITY,
    NUCLEAR,
    PLASMA;
}