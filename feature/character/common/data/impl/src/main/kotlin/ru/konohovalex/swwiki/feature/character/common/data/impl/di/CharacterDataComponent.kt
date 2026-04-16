package ru.konohovalex.swwiki.feature.character.common.data.impl.di

import dagger.Component
import ru.konohovalex.swwiki.core.cache.di.ICacheComponent
import ru.konohovalex.swwiki.core.database.di.IDatabaseComponent
import ru.konohovalex.swwiki.core.network.di.INetworkComponent
import ru.konohovalex.swwiki.feature.character.common.domain.api.di.ICharacterDomainComponent

@Component(
    modules = [
        CharacterRepositoryModule::class,
        CharacterDomainMapperModule::class,
    ],
    dependencies = [
        ICacheComponent::class,
        IDatabaseComponent::class,
        INetworkComponent::class,
    ],
)
internal interface CharacterDataComponent : ICharacterDomainComponent {
    @Component.Builder
    interface Builder {
        fun cacheComponent(cacheComponent: ICacheComponent): Builder

        fun databaseComponent(databaseComponent: IDatabaseComponent): Builder

        fun networkComponent(networkComponent: INetworkComponent): Builder

        fun build(): CharacterDataComponent
    }
}
