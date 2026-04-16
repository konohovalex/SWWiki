package ru.konohovalex.swwiki.feature.character.common.data.impl.di.initializer

import ru.konohovalex.swwiki.core.cache.di.ICacheComponent
import ru.konohovalex.swwiki.core.database.di.IDatabaseComponent
import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.core.network.di.INetworkComponent
import ru.konohovalex.swwiki.feature.character.common.data.impl.di.DaggerCharacterDataComponent
import ru.konohovalex.swwiki.feature.character.common.domain.api.di.ICharacterDomainComponent

class CharacterDomainComponentInitializer(
    private val cacheComponent: ICacheComponent,
    private val databaseComponent: IDatabaseComponent,
    private val networkComponent: INetworkComponent,
) : ComponentInitializer<ICharacterDomainComponent> {
    override fun initialize(): ICharacterDomainComponent {
        return DaggerCharacterDataComponent.builder()
            .cacheComponent(cacheComponent)
            .databaseComponent(databaseComponent)
            .networkComponent(networkComponent)
            .build()
    }
}
