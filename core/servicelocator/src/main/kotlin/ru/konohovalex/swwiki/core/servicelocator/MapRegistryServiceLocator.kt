package ru.konohovalex.swwiki.core.servicelocator

import ru.konohovalex.swwiki.core.servicelocator.exception.EntryNotFoundException
import ru.konohovalex.swwiki.core.servicelocator.provider.Provider
import kotlin.reflect.KClass

class MapRegistryServiceLocator(
    private val registry: Map<KClass<*>, Provider<*>>
) : ServiceLocator {
    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> get(clazz: KClass<T>): T =
        registry[clazz]?.provide(this) as T? ?: throw EntryNotFoundException(clazz)
}
