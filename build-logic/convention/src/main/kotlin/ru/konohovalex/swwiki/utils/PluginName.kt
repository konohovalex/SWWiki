package ru.konohovalex.swwiki.utils

/** Plugin names, as they stated in version catalog.
 * Must be changed simultaneously with version catalog. */
sealed interface PluginName {
    val versionCatalogName: String

    sealed interface Kotlin : PluginName {
        object JVM : Kotlin {
            override val versionCatalogName = "kotlin-jvm"
        }

        object KSP : Kotlin {
            override val versionCatalogName = "kotlin-ksp"
        }

        object Compose : Kotlin {
            override val versionCatalogName = "kotlin-compose"
        }

        object Serialization : Kotlin {
            override val versionCatalogName = "kotlin-serialization"
        }
    }

    sealed interface Android : PluginName {
        object Application : Android {
            override val versionCatalogName = "android-application"
        }

        object Library : Android {
            override val versionCatalogName = "android-library"
        }

        object Test : Android {
            override val versionCatalogName = "android-test"
        }
    }

    sealed interface AndroidX : PluginName {
        object Room : AndroidX {
            override val versionCatalogName = "androidx-room"
        }
    }

    sealed interface SWWiki : PluginName {
        object Kotlin {
            object Coroutines : SWWiki {
                override val versionCatalogName = "swwiki-kotlin-coroutines"
            }
        }

        object Android {
            object Application : SWWiki {
                override val versionCatalogName = "swwiki-android-application"
            }

            object Library : SWWiki {
                override val versionCatalogName = "swwiki-android-library"
            }
        }

        object Dagger : SWWiki {
            override val versionCatalogName = "swwiki-dagger"
        }
    }
}
