@file:OptIn(ExperimentalMaterial3Api::class)

package ru.konohovalex.swwiki.feature.character.details.presentation.impl.ui.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.collections.immutable.persistentListOf
import ru.konohovalex.swwiki.core.navigation.LocalNavigator
import ru.konohovalex.swwiki.core.navigation.createNavKeyBundle
import ru.konohovalex.swwiki.core.navigation.model.NavigationCommand
import ru.konohovalex.swwiki.core.ui.composable.BasicInformationChips
import ru.konohovalex.swwiki.core.ui.composable.DefaultErrorState
import ru.konohovalex.swwiki.core.ui.composable.TopAppBar
import ru.konohovalex.swwiki.core.ui.model.GenderUiModel
import ru.konohovalex.swwiki.core.viewmodel.creationExtras
import ru.konohovalex.swwiki.feature.character.details.presentation.api.CharacterDetailsBundleKeys
import ru.konohovalex.swwiki.feature.character.details.presentation.api.navigation.CharacterDetailsNavKey
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.R
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.ui.model.CharacterDetailsUiModel
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.ui.model.CharacterDetailsUiState
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.viewmodel.CharacterDetailsViewModel
import ru.konohovalex.swwiki.core.ui.R as CoreUiR

@Composable
fun CharacterDetailsScreen(
    navKey: CharacterDetailsNavKey,
    viewModelFactory: ViewModelProvider.Factory,
) {
    val navigator = LocalNavigator.current
    val navKeyBundle =
        createNavKeyBundle(CharacterDetailsBundleKeys.CHARACTER_DETAILS_NAV_KEY, navKey)
    val viewModel: CharacterDetailsViewModel = viewModel(
        modelClass = CharacterDetailsViewModel::class,
        factory = viewModelFactory,
        extras = creationExtras(navKeyBundle)
    )
    val uiState = viewModel.uiState.collectAsState()
    LaunchedEffect(viewModel) {
        viewModel.getCharacter()
    }
    CharacterDetailsUi(
        characterDetailsUiState = uiState.value,
        onBackAction = {
            navigator.perform(NavigationCommand.GoBack)
        },
    ) {
        viewModel.getCharacter()
    }
}

@Composable
private fun CharacterDetailsUi(
    characterDetailsUiState: CharacterDetailsUiState,
    onBackAction: () -> Unit,
    onRetryClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar(characterDetailsUiState, onBackAction)
        },
    ) { paddingValues ->
        when (characterDetailsUiState) {
            is CharacterDetailsUiState.Loading -> {
                LoadingState(paddingValues)
            }

            is CharacterDetailsUiState.Data -> {
                DataState(paddingValues, characterDetailsUiState.model)
            }

            is CharacterDetailsUiState.Error -> {
                ErrorState(paddingValues, onRetryClick)
            }
        }
    }
}

@Composable
private fun TopBar(
    characterDetailsUiState: CharacterDetailsUiState,
    onBackAction: () -> Unit,
) {
    val title = remember(characterDetailsUiState) {
        when (characterDetailsUiState) {
            is CharacterDetailsUiState.Data -> {
                characterDetailsUiState.model.basicInformation.name
            }

            is CharacterDetailsUiState.Error -> {
                characterDetailsUiState.characterName
            }

            is CharacterDetailsUiState.Loading -> {
                characterDetailsUiState.characterName
            }
        }
    }
    TopAppBar(title, onBackAction)
}

@Composable
private fun LoadingState(
    paddingValues: PaddingValues,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun DataState(
    paddingValues: PaddingValues,
    characterDetailsUiModel: CharacterDetailsUiModel,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp)
            .scrollable(
                state = rememberScrollState(),
                orientation = Orientation.Vertical,
            )
    ) {
        with(characterDetailsUiModel) {
            Paragraph(R.string.feature_character_details_presentation_impl_paragraph_title_basic_information) {
                BasicInformation(basicInformation)
            }
            Paragraph(R.string.feature_character_details_presentation_impl_paragraph_title_species) {
                Species(species)
            }
            Paragraph(R.string.feature_character_details_presentation_impl_paragraph_title_films) {
                Films(films)
            }
            // TODO(starships, vehicles)
        }
    }
}

@Composable
private fun Paragraph(
    @StringRes titleRes: Int,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            text = stringResource(titleRes),
        )
        Spacer(Modifier.height(8.dp))
        content()
    }
}

@Composable
private fun BasicInformation(
    basicInformation: CharacterDetailsUiModel.BasicInformation,
) {
    BasicInformationChips(getBasicInformationList(basicInformation))
}

@Composable
private fun getBasicInformationList(
    basicInformation: CharacterDetailsUiModel.BasicInformation,
) = mutableListOf<String>().apply {
    with(basicInformation) {
        add(stringResource(gender.nameRes))
        homeworld?.let {
            add(stringResource(CoreUiR.string.core_ui_homeworld, it))
        }
        add(stringResource(CoreUiR.string.core_ui_birth_year, birthYear))
        add(stringResource(CoreUiR.string.core_ui_height, height))
        add(stringResource(CoreUiR.string.core_ui_mass, mass))
        add(stringResource(CoreUiR.string.core_ui_eye_color, eyeColor))
        add(stringResource(CoreUiR.string.core_ui_hair_color, hairColor))
        add(stringResource(CoreUiR.string.core_ui_skin_color, skinColor))
    }
}

@Composable
private fun Species(species: List<CharacterDetailsUiModel.Specie>) {
    OutlinedCard(
    ) {
        if (species.isEmpty()) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = stringResource(R.string.feature_character_details_presentation_impl_no_species),
            )
        } else {
            // TODO(save position)
            LazyRow(
            ) {
                items(
                    items = species,
                ) { specie ->
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        text = specie.name,
                    )
                }
            }
        }
    }
}

@Composable
private fun Films(films: List<CharacterDetailsUiModel.Film>) {
    // TODO(save position)
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            items = films,
        ) { film ->
            OutlinedCard(
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp),
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = film.title,
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        text = film.openingCrawl,
                    )
                }
            }
        }
    }
}

@Composable
private fun ErrorState(
    paddingValues: PaddingValues,
    onRetryClick: () -> Unit,
) {
    DefaultErrorState(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        onRetryClick = onRetryClick,
    )
}

@Preview
@Composable
private fun CharacterDetailsScreenUiLoadingPreview() {
    CharacterDetailsUi(
        characterDetailsUiState = CharacterDetailsUiState.Loading(
            characterName = "Luke Skywalker",
        ),
        onRetryClick = {},
        onBackAction = {},
    )
}

@Preview
@Composable
private fun CharacterDetailsScreenUiDataPreview() {
    CharacterDetailsUi(
        characterDetailsUiState = CharacterDetailsUiState.Data(
            model = CharacterDetailsUiModel(
                basicInformation = CharacterDetailsUiModel.BasicInformation(
                    name = "Luke Skywalker",
                    birthYear = "19 BBY",
                    eyeColor = "Blue",
                    gender = GenderUiModel.MALE,
                    hairColor = "Blond",
                    height = 172,
                    mass = 77,
                    skinColor = "Fair",
                    homeworld = "Tatooine",
                ),
                films = persistentListOf(
                    CharacterDetailsUiModel.Film(
                        title = "A New Hope",
                        openingCrawl = "It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy....",
                    ),
                    CharacterDetailsUiModel.Film(
                        title = "The Empire Strikes Back",
                        openingCrawl = "It is a dark time for the\r\nRebellion. Although the Death\r\nStar has been destroyed,\r\nImperial troops have driven the\r\nRebel forces from their hidden\r\nbase and pursued them across\r\nthe galaxy.\r\n\r\nEvading the dreaded Imperial\r\nStarfleet, a group of freedom\r\nfighters led by Luke Skywalker\r\nhas established a new secret\r\nbase on the remote ice world\r\nof Hoth.\r\n\r\nThe evil lord Darth Vader,\r\nobsessed with finding young\r\nSkywalker, has dispatched\r\nthousands of remote probes into\r\nthe far reaches of space....",
                    ),
                    CharacterDetailsUiModel.Film(
                        title = "Return of the Jedi",
                        openingCrawl = "Luke Skywalker has returned to\r\nhis home planet of Tatooine in\r\nan attempt to rescue his\r\nfriend Han Solo from the\r\nclutches of the vile gangster\r\nJabba the Hutt.\r\n\r\nLittle does Luke know that the\r\nGALACTIC EMPIRE has secretly\r\nbegun construction on a new\r\narmored space station even\r\nmore powerful than the first\r\ndreaded Death Star.\r\n\r\nWhen completed, this ultimate\r\nweapon will spell certain doom\r\nfor the small band of rebels\r\nstruggling to restore freedom\r\nto the galaxy...",
                    ),
                    CharacterDetailsUiModel.Film(
                        title = "Revenge of the Sith",
                        openingCrawl = "War! The Republic is crumbling\r\nunder attacks by the ruthless\r\nSith Lord, Count Dooku.\r\nThere are heroes on both sides.\r\nEvil is everywhere.\r\n\r\nIn a stunning move, the\r\nfiendish droid leader, General\r\nGrievous, has swept into the\r\nRepublic capital and kidnapped\r\nChancellor Palpatine, leader of\r\nthe Galactic Senate.\r\n\r\nAs the Separatist Droid Army\r\nattempts to flee the besieged\r\ncapital with their valuable\r\nhostage, two Jedi Knights lead a\r\ndesperate mission to rescue the\r\ncaptive Chancellor....",
                    ),
                ),
                species = persistentListOf(),
                starships = persistentListOf(
                    CharacterDetailsUiModel.Starship(
                        name = "X-wing",
                        model = "t-47 airspeeder",
                    ),
                    CharacterDetailsUiModel.Starship(
                        name = "T-65 X-wing",
                        model = "Lambda-class T-4a shuttle",
                    ),
                ),
                vehicles = persistentListOf(
                    CharacterDetailsUiModel.Vehicle(
                        name = "Snowspeeder",
                        model = "Imperial shuttle",
                    ),
                    CharacterDetailsUiModel.Vehicle(
                        name = "Imperial Speeder Bike",
                        model = "74-Z speeder bike",
                    ),
                ),
            )
        ),
        onRetryClick = {},
        onBackAction = {},
    )
}

@Preview
@Composable
private fun CharacterDetailsScreenUiErrorPreview() {
    CharacterDetailsUi(
        characterDetailsUiState = CharacterDetailsUiState.Error(
            characterName = "Luke Skywalker",
        ),
        onRetryClick = {},
        onBackAction = {},
    )
}
