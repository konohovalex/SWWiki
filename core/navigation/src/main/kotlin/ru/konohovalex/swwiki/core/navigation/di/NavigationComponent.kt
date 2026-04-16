package ru.konohovalex.swwiki.core.navigation.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NavigatorModule::class,
    ],
)
internal interface NavigationComponent : INavigationComponent
