package com.quare.blitzsplit.main.presentation.component.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.theme.Blue900

@Composable
fun LogoutDialog(
    onLogout: () -> Unit,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        title = {
            Text(text = "Sair")
        },
        text = {
            Text(text = "Tem certeza que deseja encerrar a sessão?")
        },
        confirmButton = {
            DialogTextButton(
                text = "Confirmar",
                action = {
                    onDismiss()
                    onLogout()
                }
            )
        },
        dismissButton = {
            DialogTextButton(
                text = "Cancelar",
                action = onDismiss
            )
        },
        onDismissRequest = onDismiss
    )
}

@Composable
private fun DialogTextButton(
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

@Composable
@Preview
fun PreviewLogoutDialog() {
    BlitzSplitTheme {
        LogoutDialog(
            onLogout = {},
            onDismiss = {}
        )
    }
}
