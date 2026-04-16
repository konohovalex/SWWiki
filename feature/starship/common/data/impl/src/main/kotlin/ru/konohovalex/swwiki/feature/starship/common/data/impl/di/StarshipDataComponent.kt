package ru.konohovalex.swwiki.feature.starship.common.data.impl.di

import dagger.Component
import ru.konohovalex.swwiki.core.cache.di.CacheComponent
import ru.konohovalex.swwiki.core.database.di.DatabaseComponent
import ru.konohovalex.swwiki.core.di.qualifier.FeatureScope
import ru.konohovalex.swwiki.core.network.di.NetworkComponent
import ru.konohovalex.swwiki.feature.starship.common.domain.api.di.IStarshipDomainComponent

@FeatureScope
@Component(
    modules = [
        StarshipDomainMapperModule::class,
        StarshipRepositoryModule::class,
    ],
    dependencies = [
        CacheComponent::class,
        DatabaseComponent::class,
        NetworkComponent::class,
    ],
)
interface StarshipDataComponent : IStarshipDomainComponent {
    @Component.Builder
    interface Builder {
        fun cacheComponent(cacheComponent: CacheComponent): Builder

        fun databaseComponent(databaseComponent: DatabaseComponent): Builder

        fun networkComponent(networkComponent: NetworkComponent): Builder

        fun build(): StarshipDataComponent
    }
}
