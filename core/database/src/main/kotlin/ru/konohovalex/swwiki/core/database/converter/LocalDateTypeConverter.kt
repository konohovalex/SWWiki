package ru.konohovalex.swwiki.core.database.converter

import androidx.room.TypeConverter
import kotlinx.datetime.LocalDate

internal class LocalDateTypeConverter {
    @TypeConverter
    fun fromLocalDateTime(value: LocalDate): String {
        return value.toString()
    }

    @TypeConverter
    fun toLocalDateTime(value: String): LocalDate {
        return LocalDate.parse(value)
    }
}
