package ru.konohovalex.swwiki.core.database

import android.content.Context
import androidx.room.Room

internal class SWWikiDatabaseBuilder {
    fun build(context: Context) = Room.databaseBuilder(
        context = context,
        klass = SWWikiDatabase::class.java,
        name = "swwiki-database",
    ).build()
}
