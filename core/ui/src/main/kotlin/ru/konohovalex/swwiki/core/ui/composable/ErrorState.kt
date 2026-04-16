package ru.konohovalex.swwiki.core.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ru.konohovalex.swwiki.core.ui.R

@Composable
fun DefaultErrorState(
    modifier: Modifier = Modifier,
    onRetryClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = stringResource(R.string.core_ui_default_error),
        )
        Button(
            onClick = { onRetryClick() },
        ) {
            Text(
                text = stringResource(R.string.core_ui_default_retry),
            )
        }
    }
}

@Preview
@Composable
fun DefaultErrorStatePreview() {
    DefaultErrorState(
        modifier = Modifier
            .fillMaxSize(),
    ) {}
}
