package ru.konohovalex.swwiki.plugin

import androidx.room.gradle.RoomExtension
import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.Ksp
import ru.konohovalex.swwiki.utils.LibraryNames
import ru.konohovalex.swwiki.utils.PluginName
import ru.konohovalex.swwiki.utils.dependencies
import ru.konohovalex.swwiki.utils.plugins

class AndroidRoomConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins(
                PluginName.Kotlin.KSP,
                PluginName.AndroidX.Room,
            )

            extensions.configure<KspExtension> {
                arg("room.generateKotlin", "true")
            }

            extensions.configure<RoomExtension> {
                // The schemas directory contains a schema file for each version of the Room database.
                // This is required to enable Room auto migrations.
                // See https://developer.android.com/reference/kotlin/androidx/room/AutoMigration.
                schemaDirectory("$projectDir/schemas")
            }

            dependencies(
                Implementation(LibraryNames.AndroidX.Room.Runtime),
                Implementation(LibraryNames.AndroidX.Room.Ktx),
                Ksp(LibraryNames.AndroidX.Room.Compiler),
            )
        }
    }
}
