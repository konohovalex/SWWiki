package ru.konohovalex.swwiki.feature.vehicle.common.data.api.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime

@Entity(tableName = "vehicle")
data class VehicleEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val model: String,
    val vehicleClass: String,
    val manufacturer: String,
    val length: Float,
    val costInCredits: String,
    val crew: Int,
    val maxAtmospheringSpeed: Int,
    val cargoCapacity: Int,
    val consumables: String,
    val filmIds: List<Int>,
    val pilotIds: List<Int>,
    val editedDate: LocalDateTime,
)
