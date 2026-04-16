package ru.konohovalex.swwiki.core.servicelocator.registry

import ru.konohovalex.swwiki.core.servicelocator.exception.DuplicateEntryException
import ru.konohovalex.swwiki.core.servicelocator.exception.EntryNotFoundException
import ru.konohovalex.swwiki.core.servicelocator.provider.CachingFactory
import ru.konohovalex.swwiki.core.servicelocator.provider.InstanceProvider
import ru.konohovalex.swwiki.core.servicelocator.provider.Provider
import ru.konohovalex.swwiki.core.servicelocator.MapRegistryServiceLocator
import ru.konohovalex.swwiki.core.servicelocator.ServiceLocator
import kotlin.reflect.KClass

class MapRegistryBuilder : RegistryBuilder<MapRegistryServiceLocator> {

    private val map = mutableMapOf<KClass<*>, Provider<*>>()

    override fun <T : Any> instance(
        clazz: KClass<T>,
        instance: T,
    ): RegistryBuilder<MapRegistryServiceLocator> {
        val oldValue = map.put(clazz, InstanceProvider(instance))
        if (oldValue != null) {
            throw DuplicateEntryException(clazz)
        }
        return this
    }

    override fun <T : Any> bind(
        clazz: KClass<T>,
        creator: ServiceLocator.() -> T,
    ): RegistryBuilder<MapRegistryServiceLocator> {
        val oldValue = map.put(clazz, CachingFactory(creator))
        if (oldValue != null) {
            throw DuplicateEntryException(clazz)
        }
        return this
    }

    override fun <TARGET : Any, SOURCE : TARGET> cast(
        source: KClass<SOURCE>,
        target: KClass<TARGET>,
    ): RegistryBuilder<MapRegistryServiceLocator> {
        val sourceProvider = map[source] ?: throw EntryNotFoundException(source)
        val oldValue = map.put(target, sourceProvider)
        if (oldValue != null) {
            throw DuplicateEntryException(target)
        }
        return this
    }

    override fun build(): MapRegistryServiceLocator = MapRegistryServiceLocator(map)
}
