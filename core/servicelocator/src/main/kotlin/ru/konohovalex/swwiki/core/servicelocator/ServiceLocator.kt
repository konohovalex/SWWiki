package ru.konohovalex.swwiki.core.servicelocator

import kotlin.reflect.KClass

interface ServiceLocator {
    fun <T : Any> get(clazz: KClass<T>): T
}

inline fun <reified T : Any> ServiceLocator.get(): T = get(T::class)
