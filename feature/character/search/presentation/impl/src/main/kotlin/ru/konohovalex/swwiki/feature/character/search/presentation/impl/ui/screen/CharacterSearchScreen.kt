@file:OptIn(ExperimentalMaterial3Api::class)

package ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import ru.konohovalex.swwiki.core.navigation.LocalNavigator
import ru.konohovalex.swwiki.core.navigation.model.NavigationCommand
import ru.konohovalex.swwiki.core.ui.composable.BasicInformationText
import ru.konohovalex.swwiki.core.ui.composable.SearchField
import ru.konohovalex.swwiki.core.ui.composable.TopAppBar
import ru.konohovalex.swwiki.feature.character.details.presentation.api.navigation.CharacterDetailsNavKey
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.R
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.model.CharacterSearchResultUiModel
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.ui.model.CharacterSearchUiState
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.viewmodel.CharacterSearchViewModel
import ru.konohovalex.swwiki.core.ui.R as CoreUiR

@Composable
fun CharacterSearchScreen(
    viewModelFactory: ViewModelProvider.Factory,
) {
    val navigator = LocalNavigator.current
    val viewModel: CharacterSearchViewModel = viewModel(
        modelClass = CharacterSearchViewModel::class,
        factory = viewModelFactory,
    )
    val uiState = viewModel.uiState.collectAsState()
    CharacterSearchUi(
        characterSearchUiState = uiState.value,
        onCharacterClick = {
            navigator.perform(
                NavigationCommand.NavigateTo(
                    CharacterDetailsNavKey(it.id, it.name)
                )
            )
        },
        onQueryChanged = {
            viewModel.search(it)
        },
        onBackAction = {
            navigator.perform(NavigationCommand.GoBack)
        },
        onRetryClick = {
            viewModel.retry()
        },
    )
}

@Composable
private fun CharacterSearchUi(
    characterSearchUiState: CharacterSearchUiState,
    onCharacterClick: (CharacterSearchResultUiModel) -> Unit,
    onQueryChanged: (String) -> Unit,
    onBackAction: () -> Unit,
    onRetryClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                stringResource(R.string.feature_character_search_presentation_impl_title),
                onBackAction
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
        ) {
            SearchField(
                value = "",
                onValueChange = onQueryChanged,
                placeholder = stringResource(R.string.feature_character_search_presentation_impl_search_placeholder),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            )
            val lazyCharacters = characterSearchUiState.pagingData.collectAsLazyPagingItems()
            // TODO(save position)
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(
                    count = lazyCharacters.itemCount,
                    key = lazyCharacters.itemKey { it.id },
                ) { index ->
                    lazyCharacters[index]?.let {
                        CharacterCard(it, onCharacterClick)
                    }
                }

                // Индикатор начальной загрузки
                if (lazyCharacters.loadState.refresh is LoadState.Loading) {
                    item {
                        LoadingState(Modifier.fillMaxSize())
                    }
                }

                // Индикатор дозагрузки следующей страницы
                if (lazyCharacters.loadState.append is LoadState.Loading) {
                    item { LoadingState(Modifier.fillMaxWidth()) }
                }
            }
        }
    }
}

@Composable
private fun LoadingState(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun CharacterCard(
    character: CharacterSearchResultUiModel,
    onCharacterClick: (CharacterSearchResultUiModel) -> Unit,
) {
    OutlinedCard(
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClickLabel = stringResource(R.string.feature_character_search_presentation_impl_content_description_show_character),
                ) { onCharacterClick(character) }
                .padding(8.dp),
        ) {
            with(character) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    text = character.name,
                )
                BasicInformationText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    infos = listOf(
                        stringResource(gender.nameRes),
                        stringResource(CoreUiR.string.core_ui_birth_year, birthYear),
                        stringResource(CoreUiR.string.core_ui_height, height),
                        stringResource(CoreUiR.string.core_ui_mass, mass),
                        stringResource(CoreUiR.string.core_ui_skin_color, skinColor),
                        stringResource(CoreUiR.string.core_ui_eye_color, eyeColor),
                        stringResource(CoreUiR.string.core_ui_hair_color, hairColor),
                    )
                )
            }
        }
    }
}
