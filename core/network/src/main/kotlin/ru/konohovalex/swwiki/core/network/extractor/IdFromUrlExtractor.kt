package ru.konohovalex.swwiki.core.network.extractor

import okhttp3.HttpUrl.Companion.toHttpUrlOrNull

object IdFromUrlExtractor {
    fun extract(url: String): Int? =
        url.toHttpUrlOrNull()?.pathSegments?.let {
            it[it.lastIndex - 1].toIntOrNull()
        }
}
