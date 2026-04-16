package ru.konohovalex.swwiki.feature.character.details.presentation.impl.di

import dagger.Binds
import dagger.Module
import ru.konohovalex.swwiki.core.coroutines.DispatchersModule
import ru.konohovalex.swwiki.core.viewmodel.assisted.AssistedViewModelFactory
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.viewmodel.CharacterDetailsViewModel

@Module(includes = [DispatchersModule::class])
internal interface CharacterDetailsViewModelModule {
    @Binds
    fun bindCharacterDetailsViewModel(impl: CharacterDetailsViewModel.Factory): AssistedViewModelFactory<CharacterDetailsViewModel>
}
