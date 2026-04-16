package ru.konohovalex.swwiki.core.ui.composable

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
) {
    // TODO(customize trailingIcon and keyboardActions?)
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        placeholder = {
            Text(text = placeholder)
        },
        singleLine = true,
    )
}

@Preview
@Composable
private fun SearchFieldPreview() {
    SearchField(
        "",
        {},
        "Search..."
    )
}
