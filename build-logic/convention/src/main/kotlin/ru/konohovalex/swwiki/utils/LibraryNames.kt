package ru.konohovalex.swwiki.utils

/** Library names, as they stated in version catalog.
 * Must be changed simultaneously with version catalog. */
object LibraryNames {
    object Kotlin {
        const val Test = "kotlin-test"
    }

    object KotlinX {
        const val DateTime = "kotlinx-datetime"
        const val SerializationJson = "kotlinx-serialization-json"
        const val CollectionsImmutable = "kotlinx-collections-immutable"

        object Coroutines {
            const val Core = "kotlinx-coroutines-core"
            const val Android = "kotlinx-coroutines-android"
            const val Test = "kotlinx-coroutines-test"
            const val Debug = "kotlinx-coroutines-debug"
        }
    }

    object AndroidX {
        object Lifecycle {
            object Runtime {
                const val Ktx = "androidx-lifecycle-runtime-ktx"
                const val Compose = "androidx-lifecycle-runtime-compose"
                const val Testing = "androidx-lifecycle-runtime-testing"
            }

            object ViewModel {
                const val Ktx = "androidx-lifecycle-viewModel-ktx"
                const val Compose = "androidx-lifecycle-viewModel-compose"
                const val Navigation3 = "androidx-lifecycle-viewModel-navigation3"
                const val Testing = "androidx-lifecycle-viewModel-testing"
            }
        }

        object Compose {
            const val Bom = "androidx-compose-bom"
            const val Ui = "androidx-compose-ui"
            const val UiGraphics = "androidx-compose-ui-graphics"
            const val UiTooling = "androidx-compose-ui-tooling"
            const val UiToolingPreview = "androidx-compose-ui-tooling-preview"
            const val Material3 = "androidx-compose-material3"
            const val ActivityCompose = "androidx-activity-compose"
        }

        object Room {
            const val Runtime = "room-runtime"
            const val Ktx = "room-ktx"
            const val Compiler = "room-compiler"
        }

        const val AnnotationJvm = "androidx-annotation-jvm"
    }

    object Dagger {
        const val Core = "dagger"
        const val Compiler = "dagger-compiler"
    }
}
