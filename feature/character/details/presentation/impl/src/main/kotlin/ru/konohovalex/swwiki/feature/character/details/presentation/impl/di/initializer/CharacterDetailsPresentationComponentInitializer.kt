package ru.konohovalex.swwiki.feature.character.details.presentation.impl.di.initializer

import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.core.viewmodel.di.IViewModelComponent
import ru.konohovalex.swwiki.feature.character.details.domain.api.di.ICharacterDetailsDomainComponent
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.di.DaggerCharacterDetailsPresentationComponent
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.di.ICharacterDetailsPresentationComponent
import ru.konohovalex.swwiki.feature.character.details.presentation.impl.viewmodel.CharacterDetailsViewModel

class CharacterDetailsPresentationComponentInitializer(
    private val characterDetailsDomainComponent: ICharacterDetailsDomainComponent,
    private val viewModelComponent: IViewModelComponent,
) : ComponentInitializer<ICharacterDetailsPresentationComponent> {
    override fun initialize(): ICharacterDetailsPresentationComponent {
        return DaggerCharacterDetailsPresentationComponent.builder()
            .characterDetailsDomainComponent(characterDetailsDomainComponent)
            .build().also {
                viewModelComponent.viewModelFactoryRegistry()
                    .register(
                        CharacterDetailsViewModel::class.java,
                        it.characterDetailsViewModel()
                    )
            }
    }
}
