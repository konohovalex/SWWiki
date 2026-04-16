package ru.konohovalex.swwiki.feature.film.common.data.impl.di

import dagger.Component
import ru.konohovalex.swwiki.core.cache.di.ICacheComponent
import ru.konohovalex.swwiki.core.database.di.IDatabaseComponent
import ru.konohovalex.swwiki.core.network.di.INetworkComponent
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.di.IVehicleDomainComponent

@Component(
    modules = [
        VehicleDomainMapperModule::class,
        VehicleRepositoryModule::class,
    ],
    dependencies = [
        ICacheComponent::class,
        IDatabaseComponent::class,
        INetworkComponent::class,
    ],
)
internal interface VehicleDataComponent : IVehicleDomainComponent {
    @Component.Builder
    interface Builder {
        fun cacheComponent(cacheComponent: ICacheComponent): Builder

        fun databaseComponent(databaseComponent: IDatabaseComponent): Builder

        fun networkComponent(networkComponent: INetworkComponent): Builder

        fun build(): VehicleDataComponent
    }
}
