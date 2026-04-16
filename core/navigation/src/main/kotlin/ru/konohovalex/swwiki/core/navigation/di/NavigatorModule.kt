package ru.konohovalex.swwiki.core.navigation.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.navigation.navigator.Navigator
import ru.konohovalex.swwiki.core.navigation.navigator.impl.NavigatorImpl
import javax.inject.Singleton

@Module
internal interface NavigatorModule {
    @[Binds Singleton]
    fun bindNavigator(impl: NavigatorImpl): Navigator
}
