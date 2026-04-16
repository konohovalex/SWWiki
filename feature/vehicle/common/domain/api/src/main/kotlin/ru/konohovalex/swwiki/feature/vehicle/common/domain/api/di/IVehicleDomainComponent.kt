package ru.konohovalex.swwiki.feature.vehicle.common.domain.api.di

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.repository.VehicleRepository

interface IVehicleDomainComponent : IComponent {
    fun vehicleRepository(): VehicleRepository
}
