package ru.konohovalex.swwiki.core.navigation.di.initializer

import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.core.navigation.di.DaggerNavigationComponent
import ru.konohovalex.swwiki.core.navigation.di.INavigationComponent

class NavigationComponentInitializer : ComponentInitializer<INavigationComponent> {
    override fun initialize(): INavigationComponent {
        return DaggerNavigationComponent.create()
    }
}
