package ru.konohovalex.swwiki.core.servicelocator.registry

import ru.konohovalex.swwiki.core.servicelocator.ServiceLocator
import kotlin.reflect.KClass

interface RegistryBuilder<SL: ServiceLocator> {
    fun <T : Any> instance(
        clazz: KClass<T>,
        instance: T,
    ): RegistryBuilder<SL>

    fun <T : Any> bind(
        clazz: KClass<T>,
        creator: ServiceLocator.() -> T,
    ): RegistryBuilder<SL>

    fun <TARGET : Any, SOURCE : TARGET> cast(
        source: KClass<SOURCE>,
        target: KClass<TARGET>,
    ): RegistryBuilder<SL>

    fun build(): SL
}
