package ru.konohovalex.swwiki.core.viewmodel.di.initializer

import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer
import ru.konohovalex.swwiki.core.viewmodel.di.DaggerViewModelComponent
import ru.konohovalex.swwiki.core.viewmodel.di.IViewModelComponent

class ViewModelComponentInitializer : ComponentInitializer<IViewModelComponent> {
    override fun initialize(): IViewModelComponent {
        return DaggerViewModelComponent.create()
    }
}
