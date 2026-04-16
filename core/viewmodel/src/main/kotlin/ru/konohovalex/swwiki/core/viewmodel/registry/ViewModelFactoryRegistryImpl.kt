package ru.konohovalex.swwiki.core.viewmodel.registry

import androidx.lifecycle.ViewModel
import ru.konohovalex.swwiki.core.viewmodel.MutableAssistedViewModelFactoriesMap
import ru.konohovalex.swwiki.core.viewmodel.MutableViewModelProvidersMap
import ru.konohovalex.swwiki.core.viewmodel.assisted.AssistedViewModelFactory
import java.util.Collections.synchronizedMap
import javax.inject.Inject
import javax.inject.Provider

internal class ViewModelFactoryRegistryImpl
@Inject constructor() : ViewModelFactoryRegistry {
    private val providersMap: MutableViewModelProvidersMap =
        synchronizedMap(mutableMapOf())

    private val assistedFactoriesMap: MutableAssistedViewModelFactoriesMap =
        synchronizedMap(mutableMapOf())

    override fun getViewModelProvider(clazz: Class<out ViewModel>): Provider<out ViewModel>? {
        return synchronized(providersMap) {
            providersMap[clazz]
                ?: providersMap.asIterable()
                    .firstOrNull { clazz.isAssignableFrom(it.key) }
                    ?.value
        }
    }

    override fun getAssistedViewModelFactory(clazz: Class<out ViewModel>): AssistedViewModelFactory<out ViewModel>? {
        return synchronized(assistedFactoriesMap) {
            assistedFactoriesMap[clazz]
                ?: assistedFactoriesMap.asIterable()
                    .firstOrNull { clazz.isAssignableFrom(it.key) }
                    ?.value
        }
    }

    override fun register(
        clazz: Class<out ViewModel>,
        provider: Provider<out ViewModel>
    ) {
        providersMap[clazz] = provider
    }

    override fun register(
        clazz: Class<out ViewModel>,
        factory: AssistedViewModelFactory<out ViewModel>
    ) {
        assistedFactoriesMap[clazz] = factory
    }
}
