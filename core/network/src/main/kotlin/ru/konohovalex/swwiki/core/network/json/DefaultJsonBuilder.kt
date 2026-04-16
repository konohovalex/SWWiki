package ru.konohovalex.swwiki.core.network.json

import kotlinx.serialization.json.Json

internal class DefaultJsonBuilder {
    fun build() = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }
}
