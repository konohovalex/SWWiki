package ru.konohovalex.swwiki.core.database.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.konohovalex.swwiki.core.di.qualifier.ApplicationContext
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class,
    ]
)
internal interface DatabaseComponent : IDatabaseComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(@ApplicationContext context: Context): Builder

        fun build(): DatabaseComponent
    }
}
