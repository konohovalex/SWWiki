package ru.konohovalex.swwiki.utils

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension

/**
 * Configure Compose-specific options
 */
internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension,
) {
    plugins(
        PluginName.Kotlin.Compose
    )

    commonExtension.apply {
        buildFeatures.apply {
            compose = true
        }

        dependencies(
            Implementation(LibraryNames.KotlinX.CollectionsImmutable),

            Implementation(LibraryNames.AndroidX.Compose.Bom, isBom = true),
            Implementation(LibraryNames.AndroidX.Compose.Ui),
            Implementation(LibraryNames.AndroidX.Compose.UiGraphics),
            Implementation(LibraryNames.AndroidX.Compose.UiToolingPreview),
            Implementation(LibraryNames.AndroidX.Compose.Material3),
            Implementation(LibraryNames.AndroidX.Compose.ActivityCompose),
            AndroidTestImplementation(LibraryNames.AndroidX.Compose.Bom, isBom = true),
            DebugImplementation(LibraryNames.AndroidX.Compose.UiTooling),
        )
    }

    extensions.configure<ComposeCompilerGradlePluginExtension> {
        fun Provider<String>.onlyIfTrue() = flatMap { provider { it.takeIf(String::toBoolean) } }
        fun Provider<*>.relativeToRootProject(dir: String) = map {
            @Suppress("UnstableApiUsage")
            isolated.rootProject.projectDirectory
                .dir("build")
                .dir(projectDir.toRelativeString(rootDir))
        }.map { it.dir(dir) }

        project.providers.gradleProperty("enableComposeCompilerMetrics").onlyIfTrue()
            .relativeToRootProject("compose-metrics")
            .let(metricsDestination::set)

        project.providers.gradleProperty("enableComposeCompilerReports").onlyIfTrue()
            .relativeToRootProject("compose-reports")
            .let(reportsDestination::set)

        @Suppress("UnstableApiUsage")
        stabilityConfigurationFiles
            .add(isolated.rootProject.projectDirectory.file("compose_compiler_config.conf"))
    }
}
