package ru.konohovalex.swwiki.feature.character.details.presentation.impl.di

import ru.konohovalex.swwiki.core.di.IComponent
import ru.konohovalex.swwiki.core.viewmodel.assisted.AssistedViewModelFactory
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.viewmodel.CharacterDetailsViewModel

interface ICharacterDetailsPresentationComponent : IComponent {
    fun characterDetailsViewModel(): AssistedViewModelFactory<CharacterDetailsViewModel>
}
