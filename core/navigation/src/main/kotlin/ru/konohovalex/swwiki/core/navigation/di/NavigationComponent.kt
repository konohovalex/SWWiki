package ru.konohovalex.swwiki.core.navigation.di

import dagger.Component
import ru.konohovalex.swwiki.core.navigation.navigator.Navigator
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NavigatorModule::class,
    ],
)
interface NavigationComponent {
    fun navigator(): Navigator
}
