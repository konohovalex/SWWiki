package ru.konohovalex.swwiki.core.servicelocator.exception

import kotlin.reflect.KClass

class EntryNotFoundException(clazz: KClass<*>): Throwable("$clazz not found")
