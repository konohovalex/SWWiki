package ru.konohovalex.swwiki.feature.character.search.domain.impl.di.initializer

import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.feature.character.common.domain.api.di.ICharacterDomainComponent
import ru.konohovalex.swwiki.feature.character.search.domain.api.di.ICharacterSearchDomainComponent
import ru.konohovalex.swwiki.feature.character.search.domain.impl.di.DaggerCharacterSearchDomainComponent

class CharacterSearchDomainComponentInitializer(
    private val characterDomainComponent: ICharacterDomainComponent,
) : ComponentInitializer<ICharacterSearchDomainComponent> {
    override fun initialize(): ICharacterSearchDomainComponent {
        return DaggerCharacterSearchDomainComponent.builder()
            .characterDomainComponent(characterDomainComponent)
            .build()
    }
}
