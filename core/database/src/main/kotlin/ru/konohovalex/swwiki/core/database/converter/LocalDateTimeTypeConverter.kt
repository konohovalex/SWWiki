package ru.konohovalex.swwiki.core.database.converter

import androidx.room.TypeConverter
import kotlinx.datetime.LocalDateTime

internal class LocalDateTimeTypeConverter {
    @TypeConverter
    fun fromLocalDateTime(value: LocalDateTime): String {
        return value.toString()
    }

    @TypeConverter
    fun toLocalDateTime(value: String): LocalDateTime {
        return LocalDateTime.parse(value)
    }
}
