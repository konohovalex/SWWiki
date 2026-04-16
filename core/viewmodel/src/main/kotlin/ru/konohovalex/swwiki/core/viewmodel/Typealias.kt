package ru.konohovalex.swwiki.core.viewmodel

import androidx.lifecycle.ViewModel
import ru.konohovalex.swwiki.core.viewmodel.assisted.AssistedViewModelFactory
import javax.inject.Provider

internal typealias ViewModelProvidersMap =
        Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<out ViewModel>>

internal typealias MutableViewModelProvidersMap =
        MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<out ViewModel>>

internal typealias AssistedViewModelFactoriesMap =
        Map<Class<out ViewModel>, @JvmSuppressWildcards AssistedViewModelFactory<out ViewModel>>

internal typealias MutableAssistedViewModelFactoriesMap =
        MutableMap<Class<out ViewModel>, @JvmSuppressWildcards AssistedViewModelFactory<out ViewModel>>
