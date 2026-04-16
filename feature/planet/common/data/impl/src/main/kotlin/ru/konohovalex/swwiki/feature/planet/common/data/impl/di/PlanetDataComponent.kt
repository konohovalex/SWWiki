package ru.konohovalex.swwiki.feature.planet.common.data.impl.di

import dagger.Component
import ru.konohovalex.swwiki.core.cache.di.ICacheComponent
import ru.konohovalex.swwiki.core.database.di.IDatabaseComponent
import ru.konohovalex.swwiki.core.di.qualifier.FeatureScope
import ru.konohovalex.swwiki.core.network.di.INetworkComponent
import ru.konohovalex.swwiki.feature.planet.common.domain.api.di.IPlanetDomainComponent

@FeatureScope
@Component(
    modules = [
        PlanetDomainMapperModule::class,
        PlanetRepositoryModule::class,
    ],
    dependencies = [
        ICacheComponent::class,
        IDatabaseComponent::class,
        INetworkComponent::class,
    ],
)
internal interface PlanetDataComponent : IPlanetDomainComponent {
    @Component.Builder
    interface Builder {
        fun cacheComponent(cacheComponent: ICacheComponent): Builder

        fun databaseComponent(databaseComponent: IDatabaseComponent): Builder

        fun networkComponent(networkComponent: INetworkComponent): Builder

        fun build(): PlanetDataComponent
    }
}
