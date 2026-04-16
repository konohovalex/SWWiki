package ru.konohovalex.swwiki.feature.character.details.domain.impl.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import ru.konohovalex.swwiki.core.coroutines.DispatchersModule
import ru.konohovalex.swwiki.core.di.qualifier.Io
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.core.functional.Mapper2
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharacterModel
import ru.konohovalex.swwiki.feature.character.common.domain.api.repository.CharacterRepository
import ru.konohovalex.swwiki.feature.character.details.domain.api.model.CharacterDetailsModel
import ru.konohovalex.swwiki.feature.character.details.domain.api.usecase.GetCharacterDetailsUseCase
import ru.konohovalex.swwiki.feature.character.details.domain.impl.usecase.GetCharacterDetailsUseCaseImpl
import ru.konohovalex.swwiki.feature.film.common.domain.api.model.FilmModel
import ru.konohovalex.swwiki.feature.film.common.domain.api.repository.FilmRepository
import ru.konohovalex.swwiki.feature.planet.common.domain.api.model.PlanetModel
import ru.konohovalex.swwiki.feature.planet.common.domain.api.repository.PlanetRepository
import ru.konohovalex.swwiki.feature.specie.common.domain.api.model.SpecieModel
import ru.konohovalex.swwiki.feature.specie.common.domain.api.repository.SpecieRepository
import ru.konohovalex.swwiki.feature.starship.common.domain.api.model.StarshipModel
import ru.konohovalex.swwiki.feature.starship.common.domain.api.repository.StarshipRepository
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.model.VehicleModel
import ru.konohovalex.swwiki.feature.vehicle.common.domain.api.repository.VehicleRepository

@Module(includes = [DispatchersModule::class])
internal class CharacterDetailsUseCaseModule {
    @Provides
    fun bindGetCharacterDetailsUseCase(
        characterRepository: CharacterRepository,
        filmRepository: FilmRepository,
        planetRepository: PlanetRepository,
        specieRepository: SpecieRepository,
        starshipRepository: StarshipRepository,
        vehicleRepository: VehicleRepository,
        basicInformationMapper: Mapper2<CharacterModel, PlanetModel?, CharacterDetailsModel.BasicInformation>,
        filmMapper: Mapper<FilmModel, CharacterDetailsModel.Film>,
        specieMapper: Mapper<SpecieModel, CharacterDetailsModel.Specie>,
        starshipMapper: Mapper<StarshipModel, CharacterDetailsModel.Starship>,
        vehicleMapper: Mapper<VehicleModel, CharacterDetailsModel.Vehicle>,
        @Io
        ioDispatcher: CoroutineDispatcher,
    ): GetCharacterDetailsUseCase = GetCharacterDetailsUseCaseImpl(
        characterRepository,
        filmRepository,
        planetRepository,
        specieRepository,
        starshipRepository,
        vehicleRepository,
        basicInformationMapper,
        filmMapper,
        specieMapper,
        starshipMapper,
        vehicleMapper,
        ioDispatcher,
    )
}
