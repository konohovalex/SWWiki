package ru.konohovalex.swwiki.feature.character.search.domain.impl.di

import dagger.Component
import ru.konohovalex.swwiki.feature.character.common.domain.api.di.ICharacterDomainComponent
import ru.konohovalex.swwiki.feature.character.search.domain.api.di.ICharacterSearchDomainComponent

@Component(
    modules = [
        CharacterSearchDomainMappersModule::class,
        CharacterSearchUseCaseModule::class,
    ],
    dependencies = [
        ICharacterDomainComponent::class,
    ],
)
interface CharacterSearchDomainComponent : ICharacterSearchDomainComponent {
    @Component.Builder
    interface Builder {
        fun characterDomainComponent(component: ICharacterDomainComponent): Builder

        fun build(): CharacterSearchDomainComponent
    }
}
