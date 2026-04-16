package ru.konohovalex.swwiki.feature.specie.common.data.impl.di.initializer

import ru.konohovalex.swwiki.core.cache.di.ICacheComponent
import ru.konohovalex.swwiki.core.database.di.IDatabaseComponent
import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.core.network.di.INetworkComponent
import ru.konohovalex.swwiki.feature.specie.common.data.impl.di.DaggerSpecieDataComponent
import ru.konohovalex.swwiki.feature.specie.common.domain.api.di.ISpecieDomainComponent

class SpecieDomainComponentInitializer(
    private val cacheComponent: ICacheComponent,
    private val databaseComponent: IDatabaseComponent,
    private val networkComponent: INetworkComponent,
) : ComponentInitializer<ISpecieDomainComponent> {
    override fun initialize(): ISpecieDomainComponent {
        return DaggerSpecieDataComponent.builder()
            .cacheComponent(cacheComponent)
            .databaseComponent(databaseComponent)
            .networkComponent(networkComponent)
            .build()
    }
}
