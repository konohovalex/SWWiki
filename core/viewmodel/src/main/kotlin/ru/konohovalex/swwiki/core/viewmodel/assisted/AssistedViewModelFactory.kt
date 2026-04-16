package ru.konohovalex.swwiki.core.viewmodel.assisted

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface AssistedViewModelFactory<VM : ViewModel> {
    fun create(savedStateHandle: SavedStateHandle): VM
}
