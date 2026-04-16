package ru.konohovalex.swwiki.core.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.SavedStateHandle
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.json.Json
import ru.konohovalex.swwiki.core.navigation.navigator.Navigator

val deserializationJson by lazy {
    Json { ignoreUnknownKeys = true }
}

/** Make sure to set [kotlinx.serialization.modules.SerializersModule],
 * that supports all [NavKey] implementors for correct usage. */
val LocalJson = staticCompositionLocalOf<Json> { error("No Json provided") }

/** Before usage, make sure that [LocalJson] is properly configured,
 * or else [kotlinx.serialization.SerializationException] happens. */
@Composable
fun createNavKeyBundle(key: String, navKey: NavKey) = Bundle().apply {
    putString(key, LocalJson.current.encodeToString(navKey))
}

inline fun <reified T> SavedStateHandle.getNavKey(key: String): T? {
    return get<String>(key)?.let {
        deserializationJson.decodeFromString<T>(it)
    }
}

val LocalNavigator = staticCompositionLocalOf<Navigator> { error("No navigator provided") }
