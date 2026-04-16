package ru.konohovalex.swwiki.utils

import org.gradle.api.Project

/** Class to be used as dependency for [org.gradle.api.Project.dependencies] block
 * in build.gradle.kts and Kotlin files (convention plugins).
 * @see[ru.konohovalex.swwiki.utils.dependencies].
 *
 * @param rawNotation can be anything, that [org.gradle.api.artifacts.dsl.DependencyHandler] supports.
 * If it is String (convention plugins), it should be dependency name in version catalog form - "org-x-y".
 * Better use [LibraryNames] constants.
 *
 * @param isBom should be true only for BOM-dependencies.
 *
 * @param keepStringNotation = true must be used in cases, when dependency is not comes from version catalog,
 * thus notation is qualified as raw String with full dependency name - org.x.y:z:version. */
sealed class Dependency(
    val rawNotation: Any,
    val isBom: Boolean = false,
    val keepStringNotation: Boolean = false,
) {
    context(project: Project)
    val notation: Any
        get() = if (rawNotation is String && !keepStringNotation) {
            project.libs.findLibrary(rawNotation.versionCatalogNameToDependencyName()).get()
        } else rawNotation

    abstract val configurationName: String
}

class Implementation(
    notation: Any,
    isBom: Boolean = false,
    keepStringNotation: Boolean = false,
) : Dependency(notation, isBom, keepStringNotation) {
    override val configurationName = "implementation"
}

class Api(
    notation: Any,
    isBom: Boolean = false,
    keepStringNotation: Boolean = false,
) : Dependency(notation, isBom, keepStringNotation) {
    override val configurationName = "api"
}

class CompileOnly(
    notation: Any,
    isBom: Boolean = false,
    keepStringNotation: Boolean = false,
) : Dependency(notation, isBom, keepStringNotation) {
    override val configurationName = "compileOnly"
}

class DebugImplementation(
    notation: Any,
    isBom: Boolean = false,
    keepStringNotation: Boolean = false,
) : Dependency(notation, isBom, keepStringNotation) {
    override val configurationName = "debugImplementation"
}

class TestImplementation(
    notation: Any,
    isBom: Boolean = false,
    keepStringNotation: Boolean = false,
) : Dependency(notation, isBom, keepStringNotation) {
    override val configurationName = "testImplementation"
}

class AndroidTestImplementation(
    notation: Any,
    isBom: Boolean = false,
    keepStringNotation: Boolean = false,
) : Dependency(notation, isBom, keepStringNotation) {
    override val configurationName = "androidTestImplementation"
}

class Ksp(
    notation: Any,
    isBom: Boolean = false,
    keepStringNotation: Boolean = false,
) : Dependency(notation, isBom, keepStringNotation) {
    override val configurationName = "ksp"
}


fun String.versionCatalogNameToDependencyName() = replace('-', '.')
