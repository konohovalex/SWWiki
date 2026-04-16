package ru.konohovalex.swwiki.core.servicelocator.exception

import kotlin.reflect.KClass

class DuplicateEntryException(clazz: KClass<*>) : Throwable("$clazz was already instantiated")
