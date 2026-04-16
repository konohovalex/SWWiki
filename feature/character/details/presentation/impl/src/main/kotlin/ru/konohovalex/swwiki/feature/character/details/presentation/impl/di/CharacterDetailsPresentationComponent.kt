package ru.konohovalex.swwiki.feature.character.details.presentation.impl.di

import dagger.Component
import ru.konohovalex.swwiki.core.viewmodel.assisted.AssistedViewModelFactory
import ru.konohovalex.swwiki.feature.character.details.domain.api.di.ICharacterDetailsDomainComponent
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.viewmodel.CharacterDetailsViewModel

@Component(
    modules = [
        CharacterDetailsUiMapperModule::class,
        CharacterDetailsViewModelModule::class,
    ],
    dependencies = [
        ICharacterDetailsDomainComponent::class,
    ]
)
interface CharacterDetailsPresentationComponent {
    fun characterDetailsViewModel(): AssistedViewModelFactory<CharacterDetailsViewModel>

    @Component.Builder
    interface Builder {
        fun characterDetailsDomainComponent(component: ICharacterDetailsDomainComponent): Builder

        fun build(): CharacterDetailsPresentationComponent
    }
}
