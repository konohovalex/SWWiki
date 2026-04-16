package ru.konohovalex.swwiki.core.viewmodel.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.viewmodel.registry.ViewModelFactoryRegistry
import ru.konohovalex.swwiki.core.viewmodel.registry.ViewModelFactoryRegistryImpl
import javax.inject.Singleton

@Module
internal interface RegistryModule {
    @Binds
    @Singleton
    fun bindSavedStateViewModelFactory(impl: ViewModelFactoryRegistryImpl): ViewModelFactoryRegistry
}
