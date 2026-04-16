package ru.konohovalex.swwiki.feature.character.search.presentation.impl.di

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.viewmodel.CharacterSearchViewModel
import javax.inject.Provider

interface ICharacterSearchPresentationComponent : IComponent {
    fun characterSearchViewModel(): Provider<CharacterSearchViewModel>
}
