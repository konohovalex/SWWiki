package ru.konohovalex.swwiki.feature.character.search.presentation.impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.viewmodel.CharacterSearchViewModel

@Module
internal interface CharacterSearchViewModelModule {
    @Binds
    fun bindCharacterSearchViewModel(impl: CharacterSearchViewModel): ViewModel
}
