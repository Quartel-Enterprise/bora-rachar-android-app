package com.quare.blitzsplit.groups.presentation.components.group

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.blitzplit.component.chip.ChipComponent
import com.quare.blitzsplit.theme.Gray500

@Composable
internal fun PaidOffChipComponent(modifier: Modifier = Modifier) {
    ChipComponent(
        modifier = modifier,
        value = "Quitado!",
        color = Gray500
    )
}
