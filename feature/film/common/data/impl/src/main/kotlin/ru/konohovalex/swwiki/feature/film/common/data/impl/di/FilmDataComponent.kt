package ru.konohovalex.swwiki.feature.film.common.data.impl.di

import dagger.Component
import ru.konohovalex.swwiki.core.cache.di.ICacheComponent
import ru.konohovalex.swwiki.core.database.di.IDatabaseComponent
import ru.konohovalex.swwiki.core.network.di.INetworkComponent
import ru.konohovalex.swwiki.feature.film.common.domain.api.IFilmDomainComponent

@Component(
    modules = [
        FilmDomainMapperModule::class,
        FilmRepositoryModule::class,
    ],
    dependencies = [
        ICacheComponent::class,
        IDatabaseComponent::class,
        INetworkComponent::class,
    ],
)
internal interface FilmDataComponent : IFilmDomainComponent {
    @Component.Builder
    interface Builder {
        fun cacheComponent(cacheComponent: ICacheComponent): Builder

        fun databaseComponent(databaseComponent: IDatabaseComponent): Builder

        fun networkComponent(networkComponent: INetworkComponent): Builder

        fun build(): FilmDataComponent
    }
}
