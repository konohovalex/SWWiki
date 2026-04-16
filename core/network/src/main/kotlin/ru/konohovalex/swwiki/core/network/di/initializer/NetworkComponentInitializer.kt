package ru.konohovalex.swwiki.core.network.di.initializer

import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.core.network.di.DaggerNetworkComponent
import ru.konohovalex.swwiki.core.network.di.INetworkComponent

class NetworkComponentInitializer : ComponentInitializer<INetworkComponent> {
    override fun initialize(): INetworkComponent {
        return DaggerNetworkComponent.create()
    }
}
