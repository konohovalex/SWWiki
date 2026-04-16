package ru.konohovalex.swwiki.feature.main.impl.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import ru.konohovalex.swwiki.core.navigation.LocalJson
import ru.konohovalex.swwiki.core.navigation.LocalNavigator
import ru.konohovalex.swwiki.core.navigation.di.INavigationComponent
import ru.konohovalex.swwiki.core.servicelocator.ServiceLocator
import ru.konohovalex.swwiki.core.viewmodel.di.IViewModelComponent
import ru.konohovalex.swwiki.feature.main.impl.domain.di.initializer.MainDomainComponentInitializer
import ru.konohovalex.swwiki.feature.main.impl.presentation.di.initializer.MainPresentationComponentInitializer
import ru.konohovalex.swwiki.feature.main.impl.presentation.navigation.MainNavKey
import ru.konohovalex.swwiki.feature.main.impl.presentation.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private lateinit var savedStateConfiguration: SavedStateConfiguration
    private lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val serviceLocator = application as ServiceLocator
        val viewModelComponent = serviceLocator.get(IViewModelComponent::class)
        viewModelFactory = viewModelComponent.viewModelFactory()
        val navigationComponent = serviceLocator.get(INavigationComponent::class)

        val mainDomainComponent = MainDomainComponentInitializer()
            .initialize()
        val mainPresentationComponent = MainPresentationComponentInitializer(
            serviceLocator = serviceLocator,
            mainDomainComponent = mainDomainComponent,
            viewModelComponent = viewModelComponent,
        ).initialize()
        savedStateConfiguration = mainPresentationComponent.savedStateConfiguration()

        setContent {
            val json = remember { mainPresentationComponent.navigationJson() }
            CompositionLocalProvider(LocalJson provides json) {
                CompositionLocalProvider(LocalNavigator provides navigationComponent.navigator()) {
                    NavHost()
                }
            }
        }
    }

    @Composable
    private fun NavHost() {
        val navigator = LocalNavigator.current
        val navBackStack = rememberNavBackStack(savedStateConfiguration, MainNavKey)
        navigator.setNavBackStack(navBackStack)
        NavDisplay(
            backStack = navigator.navBackStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            entryProvider = viewModel::navigate,
        )
    }
}
