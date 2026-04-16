package ru.konohovalex.swwiki.feature.film.common.data.impl.di.initializer

import ru.konohovalex.swwiki.core.cache.di.ICacheComponent
import ru.konohovalex.swwiki.core.database.di.IDatabaseComponent
import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.core.network.di.INetworkComponent
import ru.konohovalex.swwiki.feature.film.common.data.impl.di.DaggerVehicleDataComponent
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.di.IVehicleDomainComponent

class VehicleDomainComponentInitializer(
    private val cacheComponent: ICacheComponent,
    private val databaseComponent: IDatabaseComponent,
    private val networkComponent: INetworkComponent,
) : ComponentInitializer<IVehicleDomainComponent> {
    override fun initialize(): IVehicleDomainComponent {
        return DaggerVehicleDataComponent.builder()
            .cacheComponent(cacheComponent)
            .databaseComponent(databaseComponent)
            .networkComponent(networkComponent)
            .build()
    }
}
