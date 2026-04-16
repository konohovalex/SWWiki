package ru.konohovalex.swwiki.core.navigation.model

import androidx.navigation3.runtime.NavKey

sealed interface NavigationCommand {
    data class NavigateTo(val navKey: NavKey) : NavigationCommand
    data class ReplaceWith(val navKey: NavKey) : NavigationCommand
    data class ClearAndNavigateTo(val navKey: NavKey) : NavigationCommand
    data object GoBack : NavigationCommand
}
