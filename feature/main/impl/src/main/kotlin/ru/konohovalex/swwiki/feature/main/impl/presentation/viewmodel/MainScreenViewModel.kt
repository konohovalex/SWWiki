package ru.konohovalex.swwiki.feature.main.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.feature.main.impl.domain.model.Topic
import ru.konohovalex.swwiki.feature.main.impl.domain.repository.api.TopicRepository
import ru.konohovalex.swwiki.feature.main.impl.presentation.model.MainUiState
import ru.konohovalex.swwiki.feature.main.impl.presentation.model.TopicUiModel
import javax.inject.Inject

class MainScreenViewModel
@Inject constructor(
    private val topicRepository: TopicRepository,
    private val topicToTopicUiModelMapper: Mapper<Topic, TopicUiModel>,
) : ViewModel() {
    val state: StateFlow<MainUiState>
        field = MutableStateFlow<MainUiState>(getInitialUiState())

    private fun getInitialUiState() =
        topicRepository.getTopics().map(topicToTopicUiModelMapper::invoke)
            .takeIf { it.isNotEmpty() }
            ?.toPersistentList()
            ?.let(MainUiState::Topics)
            ?: MainUiState.Error
}
