package ru.konohovalex.swwiki.core.di.initializer

import ru.konohovalex.swwiki.core.di.IComponent

/** Initializer for all IComponents.
 * Dependencies must be provided via inheritor's constructor.
 * Do not save instances of inheritors to avoid memory leaks - construct, call [initialize] and forget. */
interface ComponentInitializer<IC : IComponent> {
    fun initialize(): IC
}
