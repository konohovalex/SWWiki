package ru.konohovalex.swwiki.core.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BasicInformationChips(
    infos: List<String>,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        infos.forEach {
            BasicInformationText(it)
        }
    }
}

@Composable
fun BasicInformationText(
    infos: List<String>,
    modifier: Modifier = Modifier,
) {
    val text = remember(infos) {
        infos.joinToString(", ")
    }
    Text(
        modifier = modifier,
        text = text,
    )
}

@Composable
private fun BasicInformationText(text: String) {
    OutlinedCard(
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp),
            text = text,
        )
    }
}

@Preview
@Composable
private fun BasicInformationChipsPreview() {
    BasicInformationChips(
        listOf(
            "123",
            "567",
            "890",
            "123",
            "567",
            "890",
            "123",
            "567",
            "890",
        )
    )
}

@Preview
@Composable
private fun BasicInformationTextPreview() {
    BasicInformationText(
        listOf(
            "123",
            "567",
            "890",
            "123",
            "567",
            "890",
            "123",
            "567",
            "890",
        )
    )
}
