package ru.konohovalex.swwiki.feature.character.details.presentation.impl.di

import dagger.Component
import ru.konohovalex.swwiki.feature.character.details.domain.api.di.ICharacterDetailsDomainComponent

@Component(
    modules = [
        CharacterDetailsUiMapperModule::class,
        CharacterDetailsViewModelModule::class,
    ],
    dependencies = [
        ICharacterDetailsDomainComponent::class,
    ]
)
internal interface CharacterDetailsPresentationComponent : ICharacterDetailsPresentationComponent {
    @Component.Builder
    interface Builder {
        fun characterDetailsDomainComponent(component: ICharacterDetailsDomainComponent): Builder

        fun build(): CharacterDetailsPresentationComponent
    }
}
