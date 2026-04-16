package ru.konohovalex.swwiki.core.navigation.di

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.core.navigation.navigator.Navigator

interface INavigationComponent : IComponent {
    fun navigator(): Navigator
}
