@file:OptIn(ExperimentalMaterial3Api::class)

package ru.konohovalex.swwiki.core.ui.composable

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import ru.konohovalex.swwiki.core.ui.R

@Composable
fun TopAppBar(
    title: String,
    onBackAction: (() -> Unit)?,
) {
    if (onBackAction != null) {
        CenterAlignedTopAppBar(
            title = {
                Title(title)
            },
            navigationIcon = {
                IconButton(onClick = onBackAction) {
                    Icon(
                        painter = painterResource(R.drawable.outline_arrow_back_24),
                        contentDescription = stringResource(
                            R.string.core_ui_content_description_back
                        )
                    )
                }
            }
        )
    } else {
        TopAppBar(
            title = {
                Title(title)
            }
        )
    }
}

@Composable
private fun Title(title: String) {
    Text(
        fontWeight = FontWeight.Bold,
        text = title,
    )
}

@Preview
@Composable
private fun TopAppBarWithoutBackPreview() {
    TopAppBar("Star Wars", null)
}

@Preview
@Composable
private fun TopAppBarWithBackPreview() {
    TopAppBar("Star Wars") {}
}
