package ru.konohovalex.swwiki.core.servicelocator.provider

import ru.konohovalex.swwiki.core.servicelocator.ServiceLocator

class CachingFactory<T>(
    private val creator: ServiceLocator.() -> T
) : Provider<T> {
    private var instance: T? = null

    override fun provide(serviceLocator: ServiceLocator): T {
        instance?.let { return it }

        synchronized(this) {
            instance?.let { return it }

            return creator(serviceLocator).also { instance = it }
        }
    }
}
