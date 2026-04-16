package ru.konohovalex.swwiki.feature.main.impl.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import ru.konohovalex.swwiki.core.cache.di.CacheComponent
import ru.konohovalex.swwiki.core.database.di.DatabaseComponent
import ru.konohovalex.swwiki.core.navigation.LocalJson
import ru.konohovalex.swwiki.core.navigation.LocalNavigator
import ru.konohovalex.swwiki.core.navigation.di.NavigationComponent
import ru.konohovalex.swwiki.core.network.di.NetworkComponent
import ru.konohovalex.swwiki.core.servicelocator.ServiceLocator
import ru.konohovalex.swwiki.core.viewmodel.di.ViewModelComponent
import ru.konohovalex.swwiki.feature.character.common.data.impl.di.DaggerCharacterDataComponent
import ru.konohovalex.swwiki.feature.character.common.domain.api.di.ICharacterDomainComponent
import ru.konohovalex.swwiki.feature.character.details.domain.impl.di.DaggerCharacterDetailsDomainComponent
import ru.konohovalex.swwiki.feature.character.details.presentation.api.navigation.CharacterDetailsNavKey
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.di.CharacterDetailsPresentationComponent
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.di.DaggerCharacterDetailsPresentationComponent
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.ui.screen.CharacterDetailsScreen
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.viewmodel.CharacterDetailsViewModel
import ru.konohovalex.swwiki.feature.character.search.domain.impl.di.DaggerCharacterSearchDomainComponent
import ru.konohovalex.swwiki.feature.character.search.presentation.api.navigation.CharacterSearchNavKey
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.di.CharacterSearchPresentationComponent
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.di.DaggerCharacterSearchPresentationComponent
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.screen.CharacterSearchScreen
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.viewmodel.CharacterSearchViewModel
import ru.konohovalex.swwiki.feature.film.common.data.impl.di.DaggerFilmDataComponent
import ru.konohovalex.swwiki.feature.film.common.data.impl.di.DaggerVehicleDataComponent
import ru.konohovalex.swwiki.feature.film.common.domain.api.IFilmDomainComponent
import ru.konohovalex.swwiki.feature.main.impl.domain.di.DaggerMainDomainComponent
import ru.konohovalex.swwiki.feature.main.impl.presentation.di.DaggerMainPresentationComponent
import ru.konohovalex.swwiki.feature.main.impl.presentation.di.MainPresentationComponent
import ru.konohovalex.swwiki.feature.main.impl.presentation.navigation.MainNavKey
import ru.konohovalex.swwiki.feature.main.impl.presentation.screen.MainScreen
import ru.konohovalex.swwiki.feature.planet.common.data.impl.di.DaggerPlanetDataComponent
import ru.konohovalex.swwiki.feature.planet.common.domain.api.di.IPlanetDomainComponent
import ru.konohovalex.swwiki.feature.specie.common.data.impl.di.DaggerSpecieDataComponent
import ru.konohovalex.swwiki.feature.specie.common.domain.api.di.ISpecieDomainComponent
import ru.konohovalex.swwiki.feature.starship.common.data.impl.di.DaggerStarshipDataComponent
import ru.konohovalex.swwiki.feature.starship.common.domain.api.di.IStarshipDomainComponent
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.di.IVehicleDomainComponent

class MainActivity : ComponentActivity() {
    private var mainPresentationComponent: MainPresentationComponent? = null
    private var characterSearchPresentationComponent: CharacterSearchPresentationComponent? = null
    private var characterDetailsPresentationComponent: CharacterDetailsPresentationComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val serviceLocator = application as ServiceLocator
        val cacheComponent = serviceLocator.get(CacheComponent::class)
        val databaseComponent = serviceLocator.get(DatabaseComponent::class)
        val navigationComponent = serviceLocator.get(NavigationComponent::class)
        val networkComponent = serviceLocator.get(NetworkComponent::class)
        val viewModelComponent = serviceLocator.get(ViewModelComponent::class)

        val characterDataComponent = DaggerCharacterDataComponent.builder()
            .cacheComponent(cacheComponent)
            .databaseComponent(databaseComponent)
            .networkComponent(networkComponent)
            .build()
        val filmDataComponent = DaggerFilmDataComponent.builder()
            .cacheComponent(cacheComponent)
            .databaseComponent(databaseComponent)
            .networkComponent(networkComponent)
            .build()
        val planetDataComponent = DaggerPlanetDataComponent.builder()
            .cacheComponent(cacheComponent)
            .databaseComponent(databaseComponent)
            .networkComponent(networkComponent)
            .build()
        val specieDataComponent = DaggerSpecieDataComponent.builder()
            .cacheComponent(cacheComponent)
            .databaseComponent(databaseComponent)
            .networkComponent(networkComponent)
            .build()
        val starshipDataComponent = DaggerStarshipDataComponent.builder()
            .cacheComponent(cacheComponent)
            .databaseComponent(databaseComponent)
            .networkComponent(networkComponent)
            .build()
        val vehicleDataComponent = DaggerVehicleDataComponent.builder()
            .cacheComponent(cacheComponent)
            .databaseComponent(databaseComponent)
            .networkComponent(networkComponent)
            .build()

        setContent {
            val serializersModule = remember {
                SerializersModule {
                    polymorphic(NavKey::class) {
                        subclass(MainNavKey::class)
                        subclass(CharacterSearchNavKey::class)
                        subclass(CharacterDetailsNavKey::class)
                    }
                }
            }
            val json = remember {
                Json {
                    this.serializersModule = serializersModule
                }
            }
            CompositionLocalProvider(LocalJson provides json) {
                CompositionLocalProvider(LocalNavigator provides navigationComponent.navigator()) {
                    val navigator = LocalNavigator.current
                    val savedStateConfiguration = SavedStateConfiguration {
                        this.serializersModule = serializersModule
                    }
                    navigator.setNavBackStack(
                        rememberNavBackStack(savedStateConfiguration, MainNavKey)
                    )
                    NavDisplay(
                        backStack = navigator.navBackStack,
                        entryDecorators = listOf(
                            rememberSaveableStateHolderNavEntryDecorator(),
                            rememberViewModelStoreNavEntryDecorator()
                        ),
                    ) { navKey ->
                        when (navKey) {
                            is MainNavKey -> {
                                initializeMain(viewModelComponent)
                                NavEntry(MainNavKey) {
                                    MainScreen(viewModelComponent.viewModelFactory())
                                }
                            }

                            is CharacterSearchNavKey -> {
                                initializeCharacterSearch(
                                    characterDataComponent,
                                    viewModelComponent
                                )
                                NavEntry(CharacterSearchNavKey) {
                                    CharacterSearchScreen(viewModelComponent.viewModelFactory())
                                }
                            }

                            is CharacterDetailsNavKey -> {
                                initializeCharacterDetails(
                                    characterDataComponent,
                                    filmDataComponent,
                                    planetDataComponent,
                                    specieDataComponent,
                                    starshipDataComponent,
                                    vehicleDataComponent,
                                    viewModelComponent,
                                )
                                NavEntry(navKey) {
                                    CharacterDetailsScreen(
                                        navKey = navKey,
                                        viewModelFactory = viewModelComponent.viewModelFactory(),
                                    )
                                }
                            }

                            else -> {
                                throw IllegalArgumentException("Wrong nav key: $navKey")
                            }
                        }
                    }
                }
            }
        }
    }

    // TODO(feature initializers)
    private fun initializeMain(
        viewModelComponent: ViewModelComponent,
    ) {
        if (mainPresentationComponent == null) {
            val mainDomainComponent = DaggerMainDomainComponent.builder().build()
            mainPresentationComponent = DaggerMainPresentationComponent.builder()
                .mainDomainComponent(mainDomainComponent)
                .build()
                .also {
                    viewModelComponent.viewModelFactoryRegistry()
                        .register(
                            MainViewModel::class.java,
                            it.mainViewModelProvider()
                        )
                }
        }
    }

    private fun initializeCharacterSearch(
        characterDomainComponent: ICharacterDomainComponent,
        viewModelComponent: ViewModelComponent,
    ) {
        if (characterSearchPresentationComponent == null) {
            val characterSearchDomainComponent =
                DaggerCharacterSearchDomainComponent.builder()
                    .characterDomainComponent(characterDomainComponent)
                    .build()
            characterSearchPresentationComponent =
                DaggerCharacterSearchPresentationComponent.builder()
                    .characterSearchDomainComponent(characterSearchDomainComponent)
                    .build()
                    .also {
                        viewModelComponent.viewModelFactoryRegistry()
                            .register(
                                CharacterSearchViewModel::class.java,
                                it.characterSearchViewModel()
                            )
                    }
        }
    }

    private fun initializeCharacterDetails(
        characterDomainComponent: ICharacterDomainComponent,
        filmDomainComponent: IFilmDomainComponent,
        planetDomainComponent: IPlanetDomainComponent,
        specieDomainComponent: ISpecieDomainComponent,
        starshipDomainComponent: IStarshipDomainComponent,
        vehicleDomainComponent: IVehicleDomainComponent,
        viewModelComponent: ViewModelComponent,
    ) {
        if (characterDetailsPresentationComponent == null) {
            val characterDetailsDomainComponent =
                DaggerCharacterDetailsDomainComponent.builder()
                    .characterDomainComponent(characterDomainComponent)
                    .filmDomainComponent(filmDomainComponent)
                    .planetDomainComponent(planetDomainComponent)
                    .specieDomainComponent(specieDomainComponent)
                    .starshipDomainComponent(starshipDomainComponent)
                    .vehicleDomainComponent(vehicleDomainComponent)
                    .build()
            characterDetailsPresentationComponent =
                DaggerCharacterDetailsPresentationComponent.builder()
                    .characterDetailsDomainComponent(characterDetailsDomainComponent)
                    .build().also {
                        viewModelComponent.viewModelFactoryRegistry()
                            .register(
                                CharacterDetailsViewModel::class.java,
                                it.characterDetailsViewModel()
                            )
                    }
        }
    }
}
