package ru.konohovalex.swwiki.feature.vehicle.common.data.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class VehiclePagingDto(
    val count: Int,
    val results: List<VehicleDto>,
)
