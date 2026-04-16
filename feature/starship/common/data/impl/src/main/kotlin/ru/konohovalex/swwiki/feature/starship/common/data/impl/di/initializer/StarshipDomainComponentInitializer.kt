package ru.konohovalex.swwiki.feature.starship.common.data.impl.di.initializer

import ru.konohovalex.swwiki.core.cache.di.ICacheComponent
import ru.konohovalex.swwiki.core.database.di.IDatabaseComponent
import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.core.network.di.INetworkComponent
import ru.konohovalex.swwiki.feature.starship.common.data.impl.di.DaggerStarshipDataComponent
import ru.konohovalex.swwiki.feature.starship.common.domain.api.di.IStarshipDomainComponent

class StarshipDomainComponentInitializer(
    private val cacheComponent: ICacheComponent,
    private val databaseComponent: IDatabaseComponent,
    private val networkComponent: INetworkComponent,
) : ComponentInitializer<IStarshipDomainComponent> {
    override fun initialize(): IStarshipDomainComponent {
        return DaggerStarshipDataComponent.builder()
            .cacheComponent(cacheComponent)
            .databaseComponent(databaseComponent)
            .networkComponent(networkComponent)
            .build()
    }
}
