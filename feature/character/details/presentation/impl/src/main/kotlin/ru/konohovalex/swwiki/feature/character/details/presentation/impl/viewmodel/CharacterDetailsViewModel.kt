package ru.konohovalex.swwiki.feature.character.details.presentation.impl.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.konohovalex.swwiki.core.di.qualifier.Io
import ru.konohovalex.swwiki.core.functional.Mapper
import ru.konohovalex.swwiki.core.navigation.getNavKey
import ru.konohovalex.swwiki.core.viewmodel.assisted.AssistedViewModelFactory
import ru.konohovalex.swwiki.feature.character.details.domain.api.model.CharacterDetailsModel
import ru.konohovalex.swwiki.feature.character.details.domain.api.usecase.GetCharacterDetailsUseCase
import ru.konohovalex.swwiki.feature.character.details.presentation.api.CharacterDetailsBundleKeys
import ru.konohovalex.swwiki.feature.character.details.presentation.api.navigation.CharacterDetailsNavKey
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.ui.model.CharacterDetailsUiModel
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.ui.model.CharacterDetailsUiState

class CharacterDetailsViewModel
@AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase,
    private val characterDetailsModelToCharacterDetailsUiModelMapper: Mapper<CharacterDetailsModel, CharacterDetailsUiModel>,
    @param:Io
    private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
    private val characterDetailsNavKey = savedStateHandle
        .getNavKey<CharacterDetailsNavKey>(CharacterDetailsBundleKeys.CHARACTER_DETAILS_NAV_KEY)
        ?: throw IllegalStateException("Must provide character nav key")

    private val characterId: Int = characterDetailsNavKey.id

    private val characterName: String = characterDetailsNavKey.name

    private var getCharacterJob: Job? = null

    val uiState: StateFlow<CharacterDetailsUiState>
        field = MutableStateFlow<CharacterDetailsUiState>(
            CharacterDetailsUiState.Loading(characterName)
        )

    fun getCharacter() {
        if (getCharacterJob != null) {
            return
        }

        getCharacterJob = viewModelScope.launch {
            uiState.emit(CharacterDetailsUiState.Loading(characterName))
            val uiModel = withContext(ioDispatcher) {
                getCharacterDetailsUseCase(id = characterId)
                    ?.let(characterDetailsModelToCharacterDetailsUiModelMapper::invoke)
            }
            uiState.emit(
                uiModel?.let(CharacterDetailsUiState::Data)
                    ?: CharacterDetailsUiState.Error(characterName)
            )
            getCharacterJob = null
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<CharacterDetailsViewModel>
}
