package ru.konohovalex.swwiki.plugin

import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import ru.konohovalex.swwiki.utils.Implementation
import ru.konohovalex.swwiki.utils.LibraryNames
import ru.konohovalex.swwiki.utils.PluginName
import ru.konohovalex.swwiki.utils.plugins
import ru.konohovalex.swwiki.utils.configureFlavors
import ru.konohovalex.swwiki.utils.configureKotlinAndroid
import ru.konohovalex.swwiki.utils.dependencies
import ru.konohovalex.swwiki.utils.disableUnnecessaryAndroidTests

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins(
                PluginName.Android.Library,
            )

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                configureFlavors(this)

                testOptions.targetSdk = 36
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                testOptions.animationsDisabled = true

                // The resource prefix is derived from the module name,
                // so resources inside ":core:module1" must be prefixed with "core_module1_"
                resourcePrefix =
                    path.split("""\W""".toRegex()).drop(1).distinct().joinToString(separator = "_")
                        .lowercase() + "_"
            }

            extensions.configure<LibraryAndroidComponentsExtension> {
                disableUnnecessaryAndroidTests(target)
            }

            dependencies(
                Implementation(LibraryNames.AndroidX.AnnotationJvm),
            )

//            dependencies {
//                "androidTestImplementation"(libs.findLibrary("kotlin.test").get())
//                "testImplementation"(libs.findLibrary("kotlin.test").get())
//                "testImplementation"(libs.findLibrary("junit").get())
//
//                "implementation"(libs.findLibrary("androidx.tracing.ktx").get())
//            }
        }
    }
}
