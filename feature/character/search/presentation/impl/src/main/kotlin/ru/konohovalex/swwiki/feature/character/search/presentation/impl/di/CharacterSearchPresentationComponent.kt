package ru.konohovalex.swwiki.feature.character.search.presentation.impl.di

import dagger.Component
import ru.konohovalex.swwiki.feature.character.search.domain.api.di.ICharacterSearchDomainComponent
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.viewmodel.CharacterSearchViewModel
import javax.inject.Provider

@Component(
    modules = [
        CharacterSearchUiMapperModule::class,
        CharacterSearchViewModelModule::class,
    ],
    dependencies = [
        ICharacterSearchDomainComponent::class,
    ]
)
interface CharacterSearchPresentationComponent {
    fun characterSearchViewModel(): Provider<CharacterSearchViewModel>

    @Component.Builder
    interface Builder {
        fun characterSearchDomainComponent(component: ICharacterSearchDomainComponent): Builder

        fun build(): CharacterSearchPresentationComponent
    }
}
