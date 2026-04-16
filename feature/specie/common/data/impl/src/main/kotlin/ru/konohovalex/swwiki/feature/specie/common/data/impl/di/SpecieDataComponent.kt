package ru.konohovalex.swwiki.feature.specie.common.data.impl.di

import dagger.Component
import ru.konohovalex.swwiki.core.cache.di.CacheComponent
import ru.konohovalex.swwiki.core.database.di.DatabaseComponent
import ru.konohovalex.swwiki.core.di.qualifier.FeatureScope
import ru.konohovalex.swwiki.core.network.di.NetworkComponent
import ru.konohovalex.swwiki.feature.specie.common.domain.api.di.ISpecieDomainComponent

@FeatureScope
@Component(
    modules = [
        SpecieDomainMapperModule::class,
        SpecieRepositoryModule::class,
    ],
    dependencies = [
        CacheComponent::class,
        DatabaseComponent::class,
        NetworkComponent::class,
    ],
)
interface SpecieDataComponent : ISpecieDomainComponent {
    @Component.Builder
    interface Builder {
        fun cacheComponent(cacheComponent: CacheComponent): Builder

        fun databaseComponent(databaseComponent: DatabaseComponent): Builder

        fun networkComponent(networkComponent: NetworkComponent): Builder

        fun build(): SpecieDataComponent
    }
}
