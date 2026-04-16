package ru.konohovalex.swwiki.core.navigation.navigator

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import ru.konohovalex.swwiki.core.navigation.model.NavigationCommand

interface Navigator {
    val navBackStack: List<NavKey>
    fun setNavBackStack(navBackStack: NavBackStack<NavKey>)
    fun perform(command: NavigationCommand)
}
