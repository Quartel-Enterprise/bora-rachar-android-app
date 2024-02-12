package com.quare.blitzsplit.main.presentation.component.dialog

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.quare.blitzplit.component.dialog.DialogComponent
import com.quare.blitzsplit.theme.BlitzSplitTheme

@Composable
fun LogoutDialog(
    onLogout: () -> Unit,
    onDismiss: () -> Unit,
) {
    DialogComponent(
        title = "Sair",
        middleContent = {
            Text(text = "Tem certeza que deseja encerrar a sessão?")
        },
        confirmButtonText = "Confirmar",
        cancelButtonText = "Cancelar",
        confirmButtonClick = {
            onDismiss()
            onLogout()
        },
        onDismiss = onDismiss
    )
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
