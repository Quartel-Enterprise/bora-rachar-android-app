package com.quare.blitzplit.component.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DialogComponent(
    title: String,
    confirmButtonText: String,
    cancelButtonText: String,
    confirmButtonClick: () -> Unit,
    onDismiss: () -> Unit,
    middleContent: @Composable (() -> Unit),
    cancelButtonClick: (() -> Unit)? = null,
) {
    AlertDialog(
        title = {
            Text(text = title)
        },
        text = {
            middleContent()
        },
        confirmButton = {
            DialogTextButton(
                text = confirmButtonText,
                action = confirmButtonClick
            )
        },
        dismissButton = {
            DialogTextButton(
                text = cancelButtonText,
                action = {
                    cancelButtonClick?.invoke() ?: onDismiss()
                }
            )
        },
        onDismissRequest = onDismiss
    )
}
