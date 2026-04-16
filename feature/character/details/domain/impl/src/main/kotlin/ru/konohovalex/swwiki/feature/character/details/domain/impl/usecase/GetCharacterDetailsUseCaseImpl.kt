package ru.konohovalex.swwiki.feature.character.details.domain.impl.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.supervisorScope
import ru.konohovalex.swwiki.core.di.qualifier.Io
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.core.functional.Mapper2
import ru.konohovalex.swwiki.feature.character.common.domain.api.model.CharacterModel
import ru.konohovalex.swwiki.feature.character.common.domain.api.repository.CharacterRepository
import ru.konohovalex.swwiki.feature.character.details.domain.api.model.CharacterDetailsModel
import ru.konohovalex.swwiki.feature.character.details.domain.api.usecase.GetCharacterDetailsUseCase
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
import javax.inject.Inject

internal class GetCharacterDetailsUseCaseImpl
@Inject constructor(
    private val characterRepository: CharacterRepository,
    private val filmRepository: FilmRepository,
    private val planetRepository: PlanetRepository,
    private val specieRepository: SpecieRepository,
    private val starshipRepository: StarshipRepository,
    private val vehicleRepository: VehicleRepository,
    private val basicInformationMapper: Mapper2<CharacterModel, PlanetModel?, CharacterDetailsModel.BasicInformation>,
    private val filmMapper: Mapper<FilmModel, CharacterDetailsModel.Film>,
    private val specieMapper: Mapper<SpecieModel, CharacterDetailsModel.Specie>,
    private val starshipMapper: Mapper<StarshipModel, CharacterDetailsModel.Starship>,
    private val vehicleMapper: Mapper<VehicleModel, CharacterDetailsModel.Vehicle>,
    @param:Io
    private val ioDispatcher: CoroutineDispatcher,
) : GetCharacterDetailsUseCase {
    override suspend operator fun invoke(id: Int): CharacterDetailsModel? {
        return supervisorScope {
            characterRepository.getCharacter(id)?.let { character ->
                val homeworld = async(ioDispatcher) {
                    character.homeworldId?.let { planetRepository.getPlanet(it) }
                }
                val films = character.filmIds.map {
                    async(ioDispatcher) {
                        filmRepository.getFilm(it)
                    }
                }
                val species = character.specieIds.map {
                    async(ioDispatcher) {
                        specieRepository.getSpecie(it)
                    }
                }
                val starships = character.starshipIds.map {
                    async(ioDispatcher) {
                        starshipRepository.getStarship(it)
                    }
                }
                val vehicles = character.vehicleIds.map {
                    async(ioDispatcher) {
                        vehicleRepository.getVehicle(it)
                    }
                }
                val basicInformation = basicInformationMapper(character, homeworld.await())
                CharacterDetailsModel(
                    id = character.id,
                    basicInformation = basicInformation,
                    films = films.awaitAll().mapNotNull { it?.let(filmMapper::invoke) },
                    species = species.awaitAll().mapNotNull { it?.let(specieMapper::invoke) },
                    starships = starships.awaitAll().mapNotNull { it?.let(starshipMapper::invoke) },
                    vehicles = vehicles.awaitAll().mapNotNull { it?.let(vehicleMapper::invoke) },
                )
            }
        }
    }
}
