package ru.konohovalex.swwiki.core.viewmodel.di

import androidx.lifecycle.ViewModelProvider
import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.core.viewmodel.registry.ViewModelFactoryRegistry

interface IViewModelComponent : IComponent {
    fun viewModelFactoryRegistry(): ViewModelFactoryRegistry
    fun viewModelFactory(): ViewModelProvider.Factory
}
