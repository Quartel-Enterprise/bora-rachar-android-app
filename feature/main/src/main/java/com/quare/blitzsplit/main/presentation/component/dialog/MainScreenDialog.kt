package com.quare.blitzsplit.main.presentation.component.dialog

import androidx.compose.runtime.Composable
import com.quare.blitzsplit.main.domain.model.MainDialogType

@Composable
fun MainScreenDialog(
    dialogType: MainDialogType,
    onLogout: () -> Unit,
    onDismiss: () -> Unit,
) {
    when (dialogType) {
        MainDialogType.LOGOUT -> LogoutDialog(
            onLogout = onLogout,
            onDismiss = onDismiss
        )
        MainDialogType.RECEIVE -> {
            // TODO: ReceiveDialog()
        }
        MainDialogType.PAY -> {
            // TODO: PayDialog()
        }
    }
}
