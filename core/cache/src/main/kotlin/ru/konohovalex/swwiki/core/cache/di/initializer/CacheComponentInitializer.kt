package ru.konohovalex.swwiki.core.cache.di.initializer

import ru.konohovalex.swwiki.core.cache.di.DaggerCacheComponent
import ru.konohovalex.swwiki.core.cache.di.ICacheComponent
import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer

class CacheComponentInitializer : ComponentInitializer<ICacheComponent> {
    override fun initialize(): ICacheComponent {
        return DaggerCacheComponent.create()
    }
}
