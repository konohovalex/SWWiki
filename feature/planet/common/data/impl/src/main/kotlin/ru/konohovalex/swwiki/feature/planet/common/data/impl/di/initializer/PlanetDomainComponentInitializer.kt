package ru.konohovalex.swwiki.feature.planet.common.data.impl.di.initializer

import ru.konohovalex.swwiki.core.cache.di.ICacheComponent
import ru.konohovalex.swwiki.core.database.di.IDatabaseComponent
import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.core.network.di.INetworkComponent
import ru.konohovalex.swwiki.feature.planet.common.data.impl.di.DaggerPlanetDataComponent
import ru.konohovalex.swwiki.feature.planet.common.domain.api.di.IPlanetDomainComponent

class PlanetDomainComponentInitializer(
    private val cacheComponent: ICacheComponent,
    private val databaseComponent: IDatabaseComponent,
    private val networkComponent: INetworkComponent,
) : ComponentInitializer<IPlanetDomainComponent> {
    override fun initialize(): IPlanetDomainComponent {
        return DaggerPlanetDataComponent.builder()
            .cacheComponent(cacheComponent)
            .databaseComponent(databaseComponent)
            .networkComponent(networkComponent)
            .build()
    }
}
