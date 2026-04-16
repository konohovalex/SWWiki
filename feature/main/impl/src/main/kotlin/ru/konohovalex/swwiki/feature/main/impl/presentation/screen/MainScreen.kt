@file:OptIn(ExperimentalMaterial3Api::class)

package ru.konohovalex.swwiki.feature.main.impl.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.collections.immutable.toPersistentList
import ru.konohovalex.swwiki.core.navigation.LocalNavigator
import ru.konohovalex.swwiki.core.navigation.model.NavigationCommand
import ru.konohovalex.swwiki.feature.character.search.presentation.api.navigation.CharacterSearchNavKey
import ru.konohovalex.swwiki.feature.main.api.R
import ru.konohovalex.swwiki.feature.main.impl.presentation.viewmodel.MainScreenViewModel
import ru.konohovalex.swwiki.feature.main.impl.presentation.model.MainUiState
import ru.konohovalex.swwiki.feature.main.impl.presentation.model.TopicUiModel

@Composable
fun MainScreen(viewModelFactory: ViewModelProvider.Factory) {
    val navigator = LocalNavigator.current
    val viewModel = viewModel(modelClass = MainScreenViewModel::class, factory = viewModelFactory)
    val state = viewModel.state.collectAsState()
    Content(state.value) {
        navigator.perform(NavigationCommand.NavigateTo(CharacterSearchNavKey))
    }
}

@Composable
private fun Content(
    state: MainUiState,
    onCharactersClick: () -> Unit,
) {
    val onTopicClick = { topicUiModel: TopicUiModel ->
        when (topicUiModel) {
            TopicUiModel.CHARACTERS -> {
                onCharactersClick()
            }

            TopicUiModel.FILMS -> {

            }

            TopicUiModel.PLANETS -> {

            }

            TopicUiModel.SPECIES -> {

            }

            TopicUiModel.STARSHIPS -> {

            }

            TopicUiModel.VEHICLES -> {

            }
        }
    }

    Scaffold(
        topBar = {
            TopBar()
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            when (state) {
                is MainUiState.Topics -> {
                    TopicsState(state.topics, onTopicClick)
                }

                is MainUiState.Error -> {
                    ErrorState()
                }
            }
        }
    }
}

@Composable
private fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                fontWeight = FontWeight.Bold,
                text = stringResource(R.string.feature_main_api_topics),
            )
        },
    )
}

@Composable
private fun TopicsState(topics: List<TopicUiModel>, onClick: (TopicUiModel) -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
    ) {
        topics.forEach {
            Topic(it, onClick)
        }
    }
}

@Composable
private fun Topic(uiModel: TopicUiModel, onClick: (TopicUiModel) -> Unit) {
    OutlinedButton(
        shape = ShapeDefaults.Medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        onClick = { onClick(uiModel) },
    ) {
        Text(
            text = stringResource(uiModel.titleRes),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun ErrorState() {
    Text(
        text = stringResource(R.string.feature_main_api_error_state_message),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxSize()
    )
}

@Preview
@Composable
private fun TopicsStatePreview() {
    Content(MainUiState.Topics(TopicUiModel.entries.toPersistentList())) {}
}

@Preview
@Composable
private fun ErrorStatePreview() {
    Content(MainUiState.Error) {}
}
