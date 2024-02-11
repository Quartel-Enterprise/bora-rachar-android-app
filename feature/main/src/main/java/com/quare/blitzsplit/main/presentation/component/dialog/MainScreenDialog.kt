package com.quare.blitzsplit.main.presentation.component.dialog

import androidx.compose.runtime.Composable
import com.quare.blitzsplit.main.presentation.component.mainappbar.MainAppDialog

@Composable
fun MainScreenDialog(
    dialogType: MainAppDialog,
    onLogout: () -> Unit,
    onDismiss: () -> Unit,
) {
    when (dialogType) {
        MainAppDialog.LOGOUT -> LogoutDialog(
            onLogout = onLogout,
            onDismiss = onDismiss
        )
        MainAppDialog.RECEIVE -> TODO()
        MainAppDialog.PAY -> TODO()
    }
}
