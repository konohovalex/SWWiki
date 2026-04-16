package ru.konohovalex.swwiki.core.database.converter

import androidx.room.TypeConverter

internal class IntListConverter {
    private companion object {
        private const val SEPARATOR = ","
    }

    @TypeConverter
    fun fromIntList(value: List<Int>): String {
        return value.joinToString(SEPARATOR)
    }

    @TypeConverter
    fun toIntList(value: String): List<Int> {
        return try {
            value.split(SEPARATOR).map { it.toInt() }
        } catch (_: NumberFormatException) {
            emptyList()
        }
    }
}
