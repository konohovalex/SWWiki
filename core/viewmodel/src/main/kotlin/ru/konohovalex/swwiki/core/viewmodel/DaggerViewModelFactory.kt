package ru.konohovalex.swwiki.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import ru.konohovalex.swwiki.core.viewmodel.registry.ViewModelFactoryRegistry
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
internal class DaggerViewModelFactory
@Inject constructor(
    private val viewModelFactoryRegistry: ViewModelFactoryRegistry,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
        return create(modelClass.java, extras)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return create(modelClass, CreationExtras.Empty)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val viewModel =
            createAssistedInjectViewModel(modelClass, extras)
                ?: createInjectViewModel(modelClass)
                ?: throw IllegalArgumentException("Unknown ViewModel class $modelClass")

        try {
            @Suppress("UNCHECKED_CAST")
            return viewModel as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    private fun <T : ViewModel> createAssistedInjectViewModel(
        modelClass: Class<T>,
        creationExtras: CreationExtras,
    ): ViewModel? {
        val creator = viewModelFactoryRegistry.getAssistedViewModelFactory(modelClass)
            ?: return null

        return creator.create(creationExtras.createSavedStateHandle())
    }

    private fun <T : ViewModel> createInjectViewModel(
        modelClass: Class<T>,
    ): ViewModel? {
        val creator = viewModelFactoryRegistry.getViewModelProvider(modelClass)
            ?: return null

        return creator.get()
    }
}
