package ru.konohovalex.swwiki.feature.character.search.presentation.impl.di

import dagger.Component
import ru.konohovalex.swwiki.feature.character.search.domain.api.di.ICharacterSearchDomainComponent

@Component(
    modules = [
        CharacterSearchUiMapperModule::class,
        CharacterSearchViewModelModule::class,
    ],
    dependencies = [
        ICharacterSearchDomainComponent::class,
    ]
)
internal interface CharacterSearchPresentationComponent : ICharacterSearchPresentationComponent {
    @Component.Builder
    interface Builder {
        fun characterSearchDomainComponent(component: ICharacterSearchDomainComponent): Builder

        fun build(): CharacterSearchPresentationComponent
    }
}
