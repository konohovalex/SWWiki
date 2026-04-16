package ru.konohovalex.swwiki.core.viewmodel.di

import androidx.lifecycle.ViewModelProvider
import dagger.Component
import ru.konohovalex.swwiki.core.viewmodel.registry.ViewModelFactoryRegistry
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RegistryModule::class,
        FactoryModule::class,
    ],
)
interface ViewModelComponent {
    fun viewModelFactoryRegistry(): ViewModelFactoryRegistry
    fun viewModelFactory(): ViewModelProvider.Factory
}
