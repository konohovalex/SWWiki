package ru.konohovalex.swwiki.feature.film.common.data.impl.di

import dagger.Component
import ru.konohovalex.swwiki.core.cache.di.CacheComponent
import ru.konohovalex.swwiki.core.database.di.DatabaseComponent
import ru.konohovalex.swwiki.core.di.qualifier.FeatureScope
import ru.konohovalex.swwiki.core.network.di.NetworkComponent
import ru.konohovalex.swwiki.feature.film.common.domain.api.IFilmDomainComponent

@FeatureScope
@Component(
    modules = [
        FilmDomainMapperModule::class,
        FilmRepositoryModule::class,
    ],
    dependencies = [
        CacheComponent::class,
        DatabaseComponent::class,
        NetworkComponent::class,
    ],
)
interface FilmDataComponent : IFilmDomainComponent {
    @Component.Builder
    interface Builder {
        fun cacheComponent(cacheComponent: CacheComponent): Builder

        fun databaseComponent(databaseComponent: DatabaseComponent): Builder

        fun networkComponent(networkComponent: NetworkComponent): Builder

        fun build(): FilmDataComponent
    }
}
