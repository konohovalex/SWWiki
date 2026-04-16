package ru.konohovalex.swwiki.feature.main.impl.domain.di.initializer

import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.feature.main.impl.domain.di.DaggerMainDomainComponent
import ru.konohovalex.swwiki.feature.main.impl.domain.di.IMainDomainComponent

class MainDomainComponentInitializer : ComponentInitializer<IMainDomainComponent> {
    override fun initialize(): IMainDomainComponent {
        return DaggerMainDomainComponent.builder().build()
    }
}
