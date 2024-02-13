package com.quare.blitzsplit.main.presentation.component.dialog

import androidx.compose.runtime.Composable
import com.quare.blitzplit.component.dialog.bill.BillDialog
import com.quare.blitzplit.component.dialog.bill.list.BillDialogListComponent
import com.quare.blitzsplit.main.domain.model.MainDialogType

@Composable
fun MainScreenDialog(model: MainDialogType) {
    model.run {
        when (this) {
            is MainDialogType.Logout -> LogoutDialog(
                onLogout = onLogout,
                onDismiss = onDismiss
            )

            is MainDialogType.Bill -> BillDialog(
                title = title,
                onConfirmButtonClick = onConfirmButtonClick,
                onDismiss = onDismiss,
                middleContent = {
                    BillDialogListComponent(items)
                },
                onRevertButtonClick = onRevertButtonClick,
                mustShowRevertButton = mustShowRevertButton,
                textInfo = textInfo
            )
        }
    }
}
