package ru.konohovalex.swwiki.core.database.di.initializer

import android.app.Application
import ru.konohovalex.swwiki.core.database.di.DaggerDatabaseComponent
import ru.konohovalex.swwiki.core.database.di.IDatabaseComponent
import ru.konohovalex.swwiki.core.di.initializer.ComponentInitializer

class DatabaseComponentInitializer(
    private val application: Application,
) : ComponentInitializer<IDatabaseComponent> {
    override fun initialize(): IDatabaseComponent {
        return DaggerDatabaseComponent.builder()
            .applicationContext(application)
            .build()
    }
}
