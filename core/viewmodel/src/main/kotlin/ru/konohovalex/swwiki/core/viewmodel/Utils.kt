package ru.konohovalex.swwiki.core.viewmodel

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.lifecycle.DEFAULT_ARGS_KEY
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.plus

@Composable
fun creationExtras(bundle: Bundle) =
    (LocalViewModelStoreOwner.current as HasDefaultViewModelProviderFactory)
        .defaultViewModelCreationExtras
        .plus(
            CreationExtras {
                this[DEFAULT_ARGS_KEY] = bundle
            }
        )
