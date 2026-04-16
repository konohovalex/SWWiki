package ru.konohovalex.swwiki.feature.film.common.data.impl.di

import dagger.Component
import ru.konohovalex.swwiki.core.cache.di.CacheComponent
import ru.konohovalex.swwiki.core.database.di.DatabaseComponent
import ru.konohovalex.swwiki.core.di.qualifier.FeatureScope
import ru.konohovalex.swwiki.core.network.di.NetworkComponent
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.di.IVehicleDomainComponent

@FeatureScope
@Component(
    modules = [
        VehicleDomainMapperModule::class,
        VehicleRepositoryModule::class,
    ],
    dependencies = [
        CacheComponent::class,
        DatabaseComponent::class,
        NetworkComponent::class,
    ],
)
interface VehicleDataComponent : IVehicleDomainComponent {
    @Component.Builder
    interface Builder {
        fun cacheComponent(cacheComponent: CacheComponent): Builder

        fun databaseComponent(databaseComponent: DatabaseComponent): Builder

        fun networkComponent(networkComponent: NetworkComponent): Builder

        fun build(): VehicleDataComponent
    }
}
