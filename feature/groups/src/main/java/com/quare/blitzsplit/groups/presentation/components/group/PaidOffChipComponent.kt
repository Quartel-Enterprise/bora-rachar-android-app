package com.quare.blitzsplit.groups.presentation.components.group

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.chip.ChipComponent
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.theme.Gray500

@Composable
internal fun PaidOffChipComponent(modifier: Modifier = Modifier) {
    ChipComponent(
        modifier = modifier,
        value = "Quitado!",
        color = Gray500,
        paddingValues = PaddingValues(
            horizontal = 10.5.dp,
            vertical = 1.dp
        ),
    )
}

@Composable
@Preview
fun PaidOffChipComponentPreview() {
    BlitzSplitTheme {
        PaidOffChipComponent()
    }
}
