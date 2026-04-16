package ru.konohovalex.swwiki.feature.vehicle.common.domain.api.di

import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.repository.VehicleRepository

interface IVehicleDomainComponent {
    fun vehicleRepository(): VehicleRepository
}
