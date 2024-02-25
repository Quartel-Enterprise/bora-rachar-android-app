package com.quare.blitzplit.component.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.quare.blitzplit.component.spacer.HorizontalSpacer

@Composable
fun BillBottomActions(
    mustShowRevertButton: Boolean,
    onRevertButtonClick: () -> Unit,
    onConfirmButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.Right
    ) {
        DialogTextButton(
            text = "Reverter",
            action = onRevertButtonClick
        )
        if (mustShowRevertButton) {
            HorizontalSpacer()
            DialogTextButton(
                text = "Confirmar",
                action = onConfirmButtonClick
            )
        }
    }
}
