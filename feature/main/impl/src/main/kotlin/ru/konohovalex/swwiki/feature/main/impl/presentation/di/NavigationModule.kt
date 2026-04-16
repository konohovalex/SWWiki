package ru.konohovalex.swwiki.feature.main.impl.presentation.di

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import ru.konohovalex.swwiki.feature.character.details.presentation.api.navigation.CharacterDetailsNavKey
import ru.konohovalex.swwiki.feature.character.search.presentation.api.navigation.CharacterSearchNavKey
import ru.konohovalex.swwiki.feature.main.impl.presentation.navigation.MainNavKey

@Module
internal class NavigationModule {
    @Provides
    fun provideSerializersModule() = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(MainNavKey::class)
            subclass(CharacterSearchNavKey::class)
            subclass(CharacterDetailsNavKey::class)
        }
    }

    @Provides
    fun provideJson(serializersModule: SerializersModule) =
        Json {
            this.serializersModule = serializersModule
        }

    @Provides
    fun provideSavedStateConfiguration(serializersModule: SerializersModule) =
        SavedStateConfiguration {
            this.serializersModule = serializersModule
        }
}
