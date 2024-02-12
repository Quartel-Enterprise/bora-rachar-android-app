package com.quare.blitzplit.component.dialog

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.quare.blitzsplit.theme.Blue900

@Composable
internal fun DialogTextButton(
    text: String,
    action: () -> Unit,
) {
    TextButton(onClick = action) {
        Text(
            text = text,
            color = Blue900
        )
    }
}
