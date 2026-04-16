package ru.konohovalex.swwiki.feature.main.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import ru.konohovalex.swwiki.core.cache.di.ICacheComponent
import ru.konohovalex.swwiki.core.database.di.IDatabaseComponent
import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.core.network.di.INetworkComponent
import ru.konohovalex.swwiki.core.servicelocator.ServiceLocator
import ru.konohovalex.swwiki.core.servicelocator.get
import ru.konohovalex.swwiki.core.viewmodel.di.IViewModelComponent
import ru.konohovalex.swwiki.feature.character.common.data.impl.di.initializer.CharacterDomainComponentInitializer
import ru.konohovalex.swwiki.feature.character.common.domain.api.di.ICharacterDomainComponent
import ru.konohovalex.swwiki.feature.character.details.domain.impl.di.initializer.CharacterDetailsDomainComponentInitializer
import ru.konohovalex.swwiki.feature.character.details.presentation.api.navigation.CharacterDetailsNavKey
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.di.ICharacterDetailsPresentationComponent
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.di.initializer.CharacterDetailsPresentationComponentInitializer
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.ui.screen.CharacterDetailsScreen
import ru.konohovalex.swwiki.feature.character.search.domain.impl.di.initializer.CharacterSearchDomainComponentInitializer
import ru.konohovalex.swwiki.feature.character.search.presentation.api.navigation.CharacterSearchNavKey
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.di.ICharacterSearchPresentationComponent
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.initializer.CharacterSearchPresentationComponentInitializer
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.screen.CharacterSearchScreen
import ru.konohovalex.swwiki.feature.film.common.data.impl.di.initializer.FilmDomainComponentInitializer
import ru.konohovalex.swwiki.feature.film.common.data.impl.di.initializer.VehicleDomainComponentInitializer
import ru.konohovalex.swwiki.feature.film.common.domain.api.IFilmDomainComponent
import ru.konohovalex.swwiki.feature.main.impl.presentation.navigation.MainNavKey
import ru.konohovalex.swwiki.feature.main.impl.presentation.screen.MainScreen
import ru.konohovalex.swwiki.feature.planet.common.data.impl.di.initializer.PlanetDomainComponentInitializer
import ru.konohovalex.swwiki.feature.planet.common.domain.api.di.IPlanetDomainComponent
import ru.konohovalex.swwiki.feature.specie.common.data.impl.di.initializer.SpecieDomainComponentInitializer
import ru.konohovalex.swwiki.feature.specie.common.domain.api.di.ISpecieDomainComponent
import ru.konohovalex.swwiki.feature.starship.common.data.impl.di.initializer.StarshipDomainComponentInitializer
import ru.konohovalex.swwiki.feature.starship.common.domain.api.di.IStarshipDomainComponent
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.di.IVehicleDomainComponent
import javax.inject.Inject
import kotlin.reflect.KClass

class MainViewModel
@Inject constructor(private val serviceLocator: ServiceLocator) : ViewModel() {
    private val componentsMap = mutableMapOf<KClass<out IComponent>, IComponent>()

    private val cacheComponent: ICacheComponent
        get() = serviceLocator.get<ICacheComponent>()
    private val databaseComponent: IDatabaseComponent
        get() = serviceLocator.get<IDatabaseComponent>()
    private val networkComponent: INetworkComponent
        get() = serviceLocator.get<INetworkComponent>()
    private val viewModelComponent: IViewModelComponent
        get() = serviceLocator.get<IViewModelComponent>()

    fun navigate(navKey: NavKey): NavEntry<NavKey> {
        val viewModelFactory = viewModelComponent.viewModelFactory()
        return when (navKey) {
            is MainNavKey -> {
                NavEntry(MainNavKey) {
                    MainScreen(viewModelFactory)
                }
            }

            is CharacterSearchNavKey -> {
                initializeCharacterSearchPresentation()
                NavEntry(CharacterSearchNavKey) {
                    CharacterSearchScreen(viewModelFactory)
                }
            }

            is CharacterDetailsNavKey -> {
                initializeCharacterDetailsPresentation()
                NavEntry(navKey) {
                    CharacterDetailsScreen(
                        navKey = navKey,
                        viewModelFactory = viewModelFactory,
                    )
                }
            }

            else -> {
                throw IllegalArgumentException("Wrong nav key: $navKey")
            }
        }
    }

    private fun initializeCharacterDomain() {
        if (contains<ICharacterDomainComponent>()) {
            return
        }

        CharacterDomainComponentInitializer(
            cacheComponent = cacheComponent,
            databaseComponent = databaseComponent,
            networkComponent = networkComponent,
        ).initialize().bind()
    }

    private fun initializeFilmDomain() {
        if (contains<IFilmDomainComponent>()) {
            return
        }

        FilmDomainComponentInitializer(
            cacheComponent = cacheComponent,
            databaseComponent = databaseComponent,
            networkComponent = networkComponent,
        ).initialize().bind()
    }

    private fun initializePlanetDomain() {
        if (contains<IPlanetDomainComponent>()) {
            return
        }

        PlanetDomainComponentInitializer(
            cacheComponent = cacheComponent,
            databaseComponent = databaseComponent,
            networkComponent = networkComponent,
        ).initialize().bind()
    }

    private fun initializeSpecieDomain() {
        if (contains<ISpecieDomainComponent>()) {
            return
        }

        SpecieDomainComponentInitializer(
            cacheComponent = cacheComponent,
            databaseComponent = databaseComponent,
            networkComponent = networkComponent,
        ).initialize().bind()
    }

    private fun initializeStarshipDomain() {
        if (contains<IStarshipDomainComponent>()) {
            return
        }

        StarshipDomainComponentInitializer(
            cacheComponent = cacheComponent,
            databaseComponent = databaseComponent,
            networkComponent = networkComponent,
        ).initialize().bind()
    }

    private fun initializeVehicleDomain() {
        if (contains<IVehicleDomainComponent>()) {
            return
        }

        VehicleDomainComponentInitializer(
            cacheComponent = cacheComponent,
            databaseComponent = databaseComponent,
            networkComponent = networkComponent,
        ).initialize().bind()
    }

    private fun initializeCharacterSearchPresentation() {
        if (contains<ICharacterSearchPresentationComponent>()) {
            return
        }

        initializeCharacterDomain()

        CharacterSearchDomainComponentInitializer(
            characterDomainComponent = getBinding(),
        ).initialize().bind()
        CharacterSearchPresentationComponentInitializer(
            characterSearchDomainComponent = getBinding(),
            viewModelComponent = viewModelComponent,
        ).initialize().bind()
    }

    private fun initializeCharacterDetailsPresentation() {
        if (contains<ICharacterDetailsPresentationComponent>()) {
            return
        }

        initializeCharacterDomain()
        initializeFilmDomain()
        initializePlanetDomain()
        initializeSpecieDomain()
        initializeStarshipDomain()
        initializeVehicleDomain()

        CharacterDetailsDomainComponentInitializer(
            characterDomainComponent = getBinding(),
            filmDomainComponent = getBinding(),
            planetDomainComponent = getBinding(),
            specieDomainComponent = getBinding(),
            starshipDomainComponent = getBinding(),
            vehicleDomainComponent = getBinding(),
        ).initialize().bind()
        CharacterDetailsPresentationComponentInitializer(
            characterDetailsDomainComponent = getBinding(),
            viewModelComponent = viewModelComponent,
        ).initialize().bind()
    }

    private inline fun <reified IC : IComponent> IC.bind() {
        componentsMap[IC::class] = this
    }

    private inline fun <reified IC : IComponent> getBinding(): IC =
        componentsMap[IC::class] as IC

    private inline fun <reified IC : IComponent> contains(): Boolean =
        componentsMap.containsKey(IC::class)
}
