package ru.konohovalex.swwiki.core.navigation.navigator.impl

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import ru.konohovalex.swwiki.core.navigation.model.NavigationCommand
import ru.konohovalex.swwiki.core.navigation.navigator.Navigator
import javax.inject.Inject

internal class NavigatorImpl
@Inject constructor() : Navigator {
    private lateinit var _navBackStack: NavBackStack<NavKey>
    override val navBackStack: List<NavKey>
        get() = _navBackStack

    override fun setNavBackStack(navBackStack: NavBackStack<NavKey>) {
        _navBackStack = navBackStack
    }

    override fun perform(
        command: NavigationCommand,
    ) {
        when (command) {
            is NavigationCommand.NavigateTo -> {
                navigateTo(command.navKey)
            }

            is NavigationCommand.ReplaceWith -> {
                replaceWith(command.navKey)
            }

            is NavigationCommand.ClearAndNavigateTo -> {
                clearAndNavigateTo(command.navKey)
            }

            is NavigationCommand.GoBack -> {
                goBack()
            }
        }
    }

    private fun navigateTo(navKey: NavKey) {
        _navBackStack.add(navKey)
    }

    private fun replaceWith(navKey: NavKey) {
        if (_navBackStack.isNotEmpty()) {
            _navBackStack[_navBackStack.lastIndex] = navKey
        }
    }

    private fun clearAndNavigateTo(navKey: NavKey) {
        _navBackStack.clear()
        navigateTo(navKey)
    }

    private fun goBack() {
        _navBackStack.removeLastOrNull()
    }
}
