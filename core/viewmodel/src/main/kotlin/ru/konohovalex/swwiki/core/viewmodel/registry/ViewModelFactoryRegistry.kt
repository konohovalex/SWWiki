package ru.konohovalex.swwiki.core.viewmodel.registry

import androidx.lifecycle.ViewModel
import ru.konohovalex.swwiki.core.viewmodel.assisted.AssistedViewModelFactory
import javax.inject.Provider

interface ViewModelFactoryRegistry {
    fun register(
        clazz: Class<out ViewModel>,
        provider: Provider<out ViewModel>
    )

    fun register(
        clazz: Class<out ViewModel>,
        factory: AssistedViewModelFactory<out ViewModel>,
    )

    fun getViewModelProvider(clazz: Class<out ViewModel>): Provider<out ViewModel>?
    fun getAssistedViewModelFactory(clazz: Class<out ViewModel>): AssistedViewModelFactory<out ViewModel>?
}
