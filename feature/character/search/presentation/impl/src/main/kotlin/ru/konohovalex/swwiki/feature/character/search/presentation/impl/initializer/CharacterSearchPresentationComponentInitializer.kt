package ru.konohovalex.swwiki.feature.character.search.presentation.impl.initializer

import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.core.viewmodel.di.IViewModelComponent
import ru.konohovalex.swwiki.feature.character.search.domain.api.di.ICharacterSearchDomainComponent
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.di.DaggerCharacterSearchPresentationComponent
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.di.ICharacterSearchPresentationComponent
import ru.konohovalex.swwiki.feature.character.search.presentation.impl.viewmodel.CharacterSearchViewModel

class CharacterSearchPresentationComponentInitializer(
    private val characterSearchDomainComponent: ICharacterSearchDomainComponent,
    private val viewModelComponent: IViewModelComponent,
) : ComponentInitializer<ICharacterSearchPresentationComponent> {
    override fun initialize(): ICharacterSearchPresentationComponent {
        return DaggerCharacterSearchPresentationComponent.builder()
            .characterSearchDomainComponent(characterSearchDomainComponent)
            .build()
            .also {
                viewModelComponent.viewModelFactoryRegistry()
                    .register(
                        CharacterSearchViewModel::class.java,
                        it.characterSearchViewModel()
                    )
            }
    }
}
