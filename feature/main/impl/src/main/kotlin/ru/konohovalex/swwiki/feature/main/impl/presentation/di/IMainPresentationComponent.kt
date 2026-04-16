package ru.konohovalex.swwiki.feature.main.impl.presentation.di

import androidx.lifecycle.ViewModel
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.json.Json
import ru.konohovalex.swwiki.core.di.IComponent
import javax.inject.Provider

interface IMainPresentationComponent : IComponent {
    fun viewModelsMap(): Map<Class<out ViewModel>, Provider<ViewModel>>
    fun navigationJson(): Json
    fun savedStateConfiguration(): SavedStateConfiguration
}
