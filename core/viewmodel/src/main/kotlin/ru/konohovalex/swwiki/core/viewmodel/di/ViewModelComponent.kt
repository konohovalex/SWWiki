package ru.konohovalex.swwiki.core.viewmodel.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RegistryModule::class,
        FactoryModule::class,
    ],
)
internal interface ViewModelComponent : IViewModelComponent
