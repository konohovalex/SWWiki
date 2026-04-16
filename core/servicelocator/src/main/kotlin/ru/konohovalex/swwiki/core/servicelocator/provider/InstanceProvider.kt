package ru.konohovalex.swwiki.core.servicelocator.provider

import ru.konohovalex.swwiki.core.servicelocator.ServiceLocator

class InstanceProvider<T>(private val instance: T) : Provider<T> {
    override fun provide(serviceLocator: ServiceLocator): T =
        instance
}
