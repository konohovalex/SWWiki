package ru.konohovalex.swwiki.core.servicelocator.provider

import ru.konohovalex.swwiki.core.servicelocator.ServiceLocator

interface Provider<T> {
    fun provide(serviceLocator: ServiceLocator): T
}
